package com.powernepo.device_content.extension

import android.database.Cursor
import android.provider.MediaStore
import java.sql.Blob

inline fun <reified T> Cursor.get(column: String) = get(T::class.java, column)

fun <T> Cursor.get(clazz: Class<T>, column: String): T {
    val columnIndex = getColumnIndex(column)

    return when {
        clazz.isAssignableFrom(String::class.java) -> getString(columnIndex)
        clazz.isAssignableFrom(Integer::class.java) -> getInt(columnIndex)
        clazz.isAssignableFrom(Float::class.java) -> getFloat(columnIndex)
        clazz.isAssignableFrom(Double::class.java) -> getDouble(columnIndex)
        clazz.isAssignableFrom(Long::class.java) -> getLong(columnIndex)
        clazz.isAssignableFrom(Short::class.java) -> getShort(columnIndex)
        clazz.isAssignableFrom(Blob::class.java) -> getBlob(columnIndex)
        else -> throw NotImplementedError()
    } as T
}
