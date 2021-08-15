package com.fjbg.weather.data.repository

import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getRemoteWeather(): Flow<WeatherResponse?>
    suspend fun getCurrent(): Flow<WeatherUiState?>
    suspend fun updateLocal()
    suspend fun clearLocal()
}