package com.powernepo.offline.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = COLUMN_TABLE_NAME)
data class Mobile(
    @ColumnInfo(name = COLUMN_ID_NAME)
    @PrimaryKey
    var id: Int? = 0
)

private const val COLUMN_TABLE_NAME = "mobile"
private const val COLUMN_ID_NAME = "id"