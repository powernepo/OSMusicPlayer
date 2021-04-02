package com.powernepo.device_content.generator

import android.content.Context
import android.net.Uri

interface ContentGenerator<T> {
    fun generate(
        selection: String? = null,
        selectionArgs: Array<String>? = null,
        sortOrder: String? = null
    ): List<T>
}

fun <T> generate(uri: Uri, clazz: Class<T>, context: Context): ContentGenerator<T> =
    ContentGeneratorImpl(uri, clazz, context)

inline fun <reified T> generate(uri: Uri, context: Context) =
    generate(uri, T::class.java, context)