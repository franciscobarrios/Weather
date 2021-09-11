package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_weather")
data class CityWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val city: String,
    val country: String,
    val temperature: Double,
    val humidity: Double,
    val wind: Double,
    val icon: String,
    val active: Boolean,
    val isFavorite: Boolean
)