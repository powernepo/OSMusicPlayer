package com.powernepo.device_content.generator

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import com.powernepo.device_content.annotation.Column
import com.powernepo.device_content.exception.AnnotationNotFoundException
import com.powernepo.device_content.extension.get
import timber.log.Timber

class ContentGeneratorImpl<T> private constructor(
    private val uri: Uri,
    private val clazz: Class<T>,
    private val context: Context
) : ContentGenerator<T> {

    companion object {
        fun <T> build(
            uri: Uri,
            clazz: Class<T>,
            context: Context
        ): ContentGenerator<T> = ContentGeneratorImpl(uri, clazz, context)
    }

    private fun fields() = clazz.declaredFields.mapNotNull {
        it.getAnnotation(Column::class.java)
    }

    @SuppressLint("Recycle")
    private fun generateCursor(
        selection: String? = null,
        selectionArgs: Array<String>? = null,
        sortOrder: String? = null
    ) = try {
        context.contentResolver
            .query(
                uri,
                fields().map {
                    it.name
                }.toTypedArray(),
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
                if (cursor.moveToNext()) {
                    do {
                        val declaredConstructor = clazz.declaredConstructors.first()
                        val constructor = clazz.getConstructor(*declaredConstructor.parameterTypes)
                        val constructorParams = hashMapOf<Int, Any>()

                        for (field in clazz.declaredFields) {
                            val annotation = field.getAnnotation(Column::class.java)
                                ?: throw AnnotationNotFoundException(Column::class)
                            val annotationName = annotation.name
                            val annotationOrder = annotation.order

                            val cursorValue = cursor.get(field.type, annotationName)
                            constructorParams[annotationOrder] = cursorValue
                        }

                        val resolvedParams = constructorParams.toList().map {
                            it.second
                        }.toTypedArray()

                        val newInstance = constructor.newInstance(*resolvedParams)
                        generatedList.add(newInstance)
                    } while (cursor.moveToNext())
                }
                generatedList
            }
        }.also {
            cursor?.close()
        }
    }
}