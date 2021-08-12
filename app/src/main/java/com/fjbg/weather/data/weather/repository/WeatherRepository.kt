package com.fjbg.weather.data.weather.repository

import com.fjbg.weather.data.weather.model.WeatherDto
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getRemoteWeather()
    suspend fun getCurrent(): Flow<WeatherDto?>
    suspend fun updateLocal()
    suspend fun clearLocal()
}