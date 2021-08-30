package com.fjbg.weather.data.model

data class CityDto(
    val id: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String
)