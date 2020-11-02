package com.powernepo.offline.room.builder

import androidx.room.Database
import androidx.room.RoomDatabase
import com.powernepo.offline.room.dao.MobileDao
import com.powernepo.offline.data.entity.Mobile

@Database(
    entities = [
        Mobile::class
    ],
    exportSchema = true,
    version = databaseVersion
)
abstract class Database : RoomDatabase() {
    abstract fun mobileDao(): MobileDao
}

const val databaseName = "com.osmusicplay.offlinedata.db"
internal const val databaseVersion = 1

