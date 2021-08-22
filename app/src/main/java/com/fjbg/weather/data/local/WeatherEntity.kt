package com.fjbg.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val longitude: Float,
    val latitude: Float,
    val currentTemp: Float,
    val weatherMain: String,
    val weatherDescription: String,
    val weatherIcon: String,
    val weatherIconId: Int,
    val feelsLike: Float,
    val pressure: Float,
    val humidity: Float,
    val tempMin: Float,
    val tempMax: Float,
    val windSpeed: Float,
    val windDirection: Float,
    val windGust: Float,
    val cloud: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
    val dt: Long,
    val timezone: Int,
    val cityName: String,
    val visibility: Int,
)