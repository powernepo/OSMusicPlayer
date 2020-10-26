package com.powernepo.offline.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.powernepo.offline.data.entity.Mobile

@Dao
interface MobileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mobile: Mobile) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg mobile: Mobile) : LongArray

    @Query("SELECT * FROM mobile")
    fun all() : List<Mobile>
}