package com.powernepo.device_content.generator

import android.content.Context
import android.net.Uri

class ContentBuilderImpl<T> : ContentBuilder<T> {
    private var clazz: Class<T>? = null
    private var uri: Uri? = null

    override fun onClass(clazz: Class<T>) = apply {
        this.clazz = clazz
    }

    override fun onContent(uri: Uri) = apply {
        this.uri = uri
    }

    override fun build(context: Context): ContentGenerator<T> = ContentGeneratorImpl(
        uri = uri!!,
        clazz = clazz!!,
        context = context
    )
}