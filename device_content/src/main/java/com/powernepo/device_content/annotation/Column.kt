package com.powernepo.device_content.annotation

@Retention
@Target(AnnotationTarget.FIELD)
annotation class Column(
    val name: String
)