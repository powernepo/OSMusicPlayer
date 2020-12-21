package com.powernepo.device_content.exception

import kotlin.reflect.KClass

class AnnotationNotFoundException(
    private val annotation: KClass<*>
) : Throwable() {

    override fun toString() = "Annotation not found $annotation"
}