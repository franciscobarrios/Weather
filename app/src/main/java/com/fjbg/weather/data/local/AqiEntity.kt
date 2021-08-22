package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "air_quality_index")
data class AqiEntity(
    @PrimaryKey
    val id: Int,
    val aqi:Int,
)