package com.powernepo.device_content

import com.powernepo.device_content.annotation.Column
import com.powernepo.device_content.mock.Car
import org.junit.Test

class AnnotationTest {
    @Test
    fun shouldRecoverColumnField(){
        val clazz = Car::class.java
        val columnFields = clazz.declaredFields.mapNotNull {
            it.getDeclaredAnnotation(Column::class.java)
        }

        assert(columnFields.isNotEmpty())
    }

    @Test
    fun shouldGenerateClassOnReflection() {
        val clazz = Car::class.java
        val declaredConstructor = clazz.declaredConstructors
        val constructor = clazz.getConstructor(*declaredConstructor[0].parameterTypes)

        val instance = constructor.newInstance("")
        instance.name
    }
}