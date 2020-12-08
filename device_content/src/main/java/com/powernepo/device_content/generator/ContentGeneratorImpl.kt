package com.powernepo.device_content.generator

import android.content.Context
import android.net.Uri
import com.powernepo.device_content.annotation.Column
import com.powernepo.device_content.exception.AnnotationNotFoundException
import com.powernepo.device_content.extension.get
import timber.log.Timber

class ContentGeneratorImpl<T>(
    private val uri: Uri,
    private val clazz: Class<T>,
    private val context: Context
) : ContentGenerator<T> {

    private fun fields() = clazz.declaredFields.mapNotNull {
        it.getAnnotation(Column::class.java)
    }

    private fun generateCursor() = try {
        context.contentResolver
            .query(
                uri,
                fields().map {
                    it.name
                }.toTypedArray(),
                null,
                null,
                null
            )
    } catch (t: Throwable) {
        Timber.e(t)
        null
    }

    override fun generate(): List<T> {
        val cursor = generateCursor()

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
                            if (field.isAnnotationPresent(Column::class.java)) {
                                val annotation = field.getAnnotation(Column::class.java)!!
                                val annotationName = annotation.name
                                val annotationOrder = annotation.order

                                val cursorValue = cursor.get(field.type, annotationName)
                                constructorParams[annotationOrder] = cursorValue
                            } else {
                                throw AnnotationNotFoundException(Column::class)
                            }
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
        }
    }


}