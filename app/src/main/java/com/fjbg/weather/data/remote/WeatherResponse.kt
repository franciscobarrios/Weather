package com.fjbg.weather.data.remote

data class WeatherResponse(
    val coord: Coordinate,
    val weather: List<Weather>,
    val main: MainResponse,
    val visibility: Int,
    val wind: Wind,
    val clouds: Cloud?,
    val dt: Long,
    val sys: WeatherSys,
    val timezone: Int,
    val name: String,
)

data class Coordinate(
    val lon: Double,
    val lat: Double,
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

data class MainResponse(
    val temp: Double,
    val feels_like: Double,
    val pressure: Double,
    val humidity: Double,
    val temp_min: Double,
    val temp_max: Double,
)

data class Wind(
    val speed: Double,
    val deg: Double,
    val gust: Double,
)

data class Cloud(
    val all: Int,
)

data class WeatherSys(
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)

