package com.fjbg.weather.data.repository

import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getRemoteWeather(): Flow<NetworkResponse<WeatherResponse?>>
    suspend fun getCurrent(): Flow<WeatherUiState?>
    suspend fun clearLocal()
    suspend fun getCurrentTemperature(): Flow<Double?>
    suspend fun getHumidity(): Flow<Double?>
    suspend fun getDescriptionMain(): Flow<String>
    suspend fun getDescription(): Flow<String>
    suspend fun getCity(): Flow<String>
}