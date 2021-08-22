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
    val lon: Float,
    val lat: Float,
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

data class MainResponse(
    val temp: Float,
    val feels_like: Float,
    val pressure: Float,
    val humidity: Float,
    val temp_min: Float,
    val temp_max: Float,
)

data class Wind(
    val speed: Float,
    val deg: Float,
    val gust: Float,
)

data class Cloud(
    val all: Int,
)

data class WeatherSys(
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)

