package com.fjbg.weather.data.remote

data class CityResponse(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String
)