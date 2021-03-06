package com.fjbg.weather.data.repository

import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getRemoteWeather(): Flow<NetworkResponse<WeatherResponse?>>
    suspend fun getCurrent(): Flow<WeatherUiState?>
    suspend fun clearLocal()
    suspend fun getCurrentTemperature(): Flow<Float?>
    suspend fun getHumidity(): Flow<Float?>
    suspend fun getWindSpeed(): Flow<Float?>
    suspend fun getDescriptionMain(): Flow<String?>
    suspend fun getDescription(): Flow<String?>
    suspend fun getCity(): Flow<String?>
    suspend fun getCountry(): Flow<String?>
    suspend fun getIcon(): Flow<String?>
    suspend fun getIconId(): Flow<Int?>
    suspend fun getDate(): Flow<Long?>
}