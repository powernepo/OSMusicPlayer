package com.powernepo.device_content.annotation

@Retention
@Target(AnnotationTarget.FIELD)
/**
 * @property order its because java reflection does not return fields as was declared. I need to know order to invoke constructor
 * @property name its a column name, dã
 * */
annotation class Column(
    val order: Int,
    val name: String
)