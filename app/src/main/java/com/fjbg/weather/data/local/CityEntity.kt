package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String
)