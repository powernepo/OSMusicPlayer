package com.powernepo.common_android.delegate

import android.view.View
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

inline fun <reified T : Any> Fragment.binding() = LazyBinding(this, T::class)

class LazyBinding<T : Any>(
    private val parent: Fragment,
    private val kClass: KClass<T>
) : Lazy<T> {
    private var cache: T? = null

    override val value: T
        get() = if (cache == null) {
            val method = kClass.java.getMethod("bind", View::class.java)
            (method.invoke(null, parent.view) as T).apply {
                cache = this
            }
        } else {
            cache!!
        }

    override fun isInitialized() = cache != null
}