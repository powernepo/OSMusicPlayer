package com.powernepo.offlinedata.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.powernepo.offlinedata.entities.MobileEntity

@Dao
interface MobileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg mobile: MobileEntity)

}