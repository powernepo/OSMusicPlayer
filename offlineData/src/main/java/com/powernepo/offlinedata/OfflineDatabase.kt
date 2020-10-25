package com.powernepo.offlinedata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.powernepo.offlinedata.dao.MobileDao
import com.powernepo.offlinedata.entities.MobileEntity

@Database(entities = [MobileEntity::class], exportSchema = false, version = 1)
abstract class OfflineDatabase : RoomDatabase(){

    companion object{

        private var INSTANCE : OfflineDatabase? = null

        fun getInstance(context: Context) : OfflineDatabase = INSTANCE ?:
        Room.databaseBuilder(context.applicationContext,
                             OfflineDatabase::class.java,
                             Constant.databaseName).build().apply {
            INSTANCE = this
        }

    }

    abstract fun getMobileDao() : MobileDao
    // add here all DAO, when exist

}

