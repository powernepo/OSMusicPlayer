package com.powernepo.offlinedata.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = MobileEntity.COLUMN_TABLE_NAME)
class MobileEntity(

    @ColumnInfo(name = COLUMN_ID_NAME) var id: Int? = 0) {

    companion object{
        const val COLUMN_TABLE_NAME = "mobile"
        const val COLUMN_ID_NAME = "id"
    }

}