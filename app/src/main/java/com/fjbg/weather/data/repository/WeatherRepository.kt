package com.fjbg.weather.data.repository

import com.fjbg.weather.data.model.WeatherDto

interface WeatherRepository {
    suspend fun getRemoteWeather()
    suspend fun getCurrent(): WeatherDto
    suspend fun updateLocal()
    suspend fun clearLocal()
}