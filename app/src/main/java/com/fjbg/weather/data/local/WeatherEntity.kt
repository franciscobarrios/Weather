package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val longitude: Double,
    val latitude: Double,
    val currentTemp: Double,
    val feelsLike: Double,
    val pressure: Double,
    val humidity: Double,
    val tempMin: Double,
    val tempMax: Double,
    val windSpeed: Double,
    val windDirection: Double,
    val windGust: Double,
    val cloud: Int,
    val dt: Int,
    val timezone: Int,
    val name: String,
    val visibility: Int,
)