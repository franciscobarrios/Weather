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
    val weatherMain: String,
    val weatherDescription: String,
    val weatherIcon: String,
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
    val cityName: String,
    val visibility: Int,
)