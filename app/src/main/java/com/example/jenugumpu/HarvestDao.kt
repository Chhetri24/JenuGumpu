package com.example.jenugumpu

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HarvestDao {
    @Insert
    suspend fun insert(harvest: Harvest)

    @Query("SELECT * FROM harvests")
    suspend fun getAllHarvests(): List<Harvest>

    @Query("SELECT COALESCE(SUM(CAST(quantity AS FLOAT)), 0.0) FROM harvests")
    suspend fun getTotalStock(): Float
}