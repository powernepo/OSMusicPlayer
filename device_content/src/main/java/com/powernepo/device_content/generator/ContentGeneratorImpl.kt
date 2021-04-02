package com.powernepo.device_content.generator

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import com.powernepo.device_content.annotation.Column
import com.powernepo.device_content.exception.AnnotationNotFoundException
import com.powernepo.device_content.extension.get
import timber.log.Timber
import java.lang.reflect.Field

class ContentGeneratorImpl<T> constructor(
    private val uri: Uri,
    private val clazz: Class<T>,
    private val context: Context
) : ContentGenerator<T> {

    private val fields get() = clazz.declaredFields.filter {
        it.isAnnotationPresent(Column::class.java)
    }.mapNotNull {
        it.getAnnotation(Column::class.java)
    }

    private val fieldsNames = fields.map {
        it.name
    }

    @SuppressLint("Recycle")
    private fun generateCursor(
        selection: String? = null,
        selectionArgs: Array<String>? = null,
        sortOrder: String? = null
    ) = try {
        context
            .contentResolver
            .query(
                uri,
                fieldsNames.toTypedArray(),
                selection,
                selectionArgs,
                sortOrder
            )
    } catch (t: Throwable) {
        Timber.e(t)
        null
    }

    override fun generate(
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): List<T> {
        val cursor = generateCursor(selection, selectionArgs, sortOrder)

        return when {
            cursor == null || cursor.count == 0 -> mutableListOf()
            else -> {
                val generatedList = mutableListOf<T>()
                if (cursor.moveToFirst()) {
                    do {
                        val declaredConstructor = clazz.declaredConstructors.let {
                            if (it.isEmpty() || it.size > 1) {
                                throw RuntimeException("Content class must have only one constructor")
                            }
                            it.first()
                        }

                        val constructor = clazz.getConstructor(*declaredConstructor.parameterTypes)
                        val constructorParams = hashMapOf<Int, Any>()

                        for (field in clazz.declaredFields) {
                            val annotation: Column = field.getAnnotation(Column::class.java)
                                ?: throw AnnotationNotFoundException(Column::class)
                            val (order: Int, name: String) =
                                Pair(annotation.order, annotation.name)

                            val cursorValue = cursor.get(field.type, name)
                            constructorParams[order] = cursorValue
                        }



                        val resolvedParams = constructorParams.toList().map {
                            it.second
                        }.toTypedArray()

                        val newInstance: T = constructor.newInstance(*resolvedParams)
                        generatedList += newInstance
                    } while (cursor.moveToNext())
                }
                generatedList
            }
        }.also {
            cursor?.close()
        }
    }
}