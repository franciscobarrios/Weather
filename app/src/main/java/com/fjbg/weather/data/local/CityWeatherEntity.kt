package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_weather")
data class CityWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val city: String,
    val country: String,
    var temperature: Double,
    val humidity: Double,
    val wind: Double,
    val icon: Int,
    val active: Boolean,
    val isFavorite: Boolean,
    val timeOfTheDay: Int,
)