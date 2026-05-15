package com.example.jenugumpu

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "harvests")
data class Harvest(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String = "",
    val location: String = "",
    val quantity: String = "",
    val floralSource: String = ""
)