package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aqi")
data class AqiEntity(
    @PrimaryKey
    val id: Int,
)