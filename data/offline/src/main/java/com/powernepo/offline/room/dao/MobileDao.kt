package com.powernepo.offline.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.powernepo.offline.data.entity.Mobile

@Dao
interface MobileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg mobile: Mobile)

}