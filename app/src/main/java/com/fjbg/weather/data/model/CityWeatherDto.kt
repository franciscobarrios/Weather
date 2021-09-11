package com.fjbg.weather.data.model

data class CityWeatherDto(
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