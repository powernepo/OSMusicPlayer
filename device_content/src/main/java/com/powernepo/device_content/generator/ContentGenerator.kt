package com.powernepo.device_content.generator

import android.database.Cursor
import com.powernepo.device_content.annotation.Column

interface ContentGenerator<T> {
    fun generateList() : List<T>
    fun generateCursor() : Cursor?
    fun fields() : List<Column>
}