package com.powernepo.device_content.extension

import android.content.Context
import android.net.Uri
import com.powernepo.device_content.generator.ContentGenerator
import com.powernepo.device_content.generator.ContentGeneratorImpl

fun <T> generate(uri: Uri, clazz: Class<T>, context: Context): ContentGenerator<T> =
    ContentGeneratorImpl.build(uri, clazz, context)

inline fun <reified T> generate(uri: Uri, context: Context) =
    generate(uri, T::class.java, context)