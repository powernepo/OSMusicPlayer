package com.powernepo.device_content.generator

interface ContentGenerator<T> {
    fun generate(selection: String? = null, selectionArgs: Array<String>? = null, sortOrder: String? = null) : List<T>
}