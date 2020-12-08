package com.powernepo.device_content.generator

import android.content.Context
import android.net.Uri

interface ContentBuilder<T> {
    fun onClass(clazz: Class<T>): ContentBuilder<T>
    fun onContent(uri: Uri): ContentBuilder<T>

    fun build(context: Context): ContentGenerator<T>
}