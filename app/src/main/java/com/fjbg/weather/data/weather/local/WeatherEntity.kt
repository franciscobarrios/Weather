package com.fjbg.weather.data.weather.local

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

//data class WeatherResponse(
//    val coord: Coordinate,
//    val weather: List<Weather>,
//    val main: MainResponse,
//    val visibility: Int,
//    val wind: Wind,
//    val clouds: Cloud?,
//    val dt: Int,
//    val timezone: Int,
//    val name: String,
//)
//