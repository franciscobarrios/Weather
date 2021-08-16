package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.mapper.mapToModel
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.di.WeatherService
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    private val database: AppDatabase,
) : WeatherRepository {

    override suspend fun getRemoteWeather(): Flow<NetworkResponse<WeatherResponse?>> {
        val entity = weatherService.getWeather()?.mapToEntity()
        return when {
            entity != null -> {
                clearLocal()
                entity.let { database.weatherDao().insertWeather(it) }
                return flowOf(NetworkResponse.Success(true))
            }
            else -> flowOf(NetworkResponse.Error(Throwable("no data")))
        }
    }

    override suspend fun getCurrent(): Flow<WeatherUiState?> {
        val current = database.weatherDao().getCurrentWeather()
        return flowOf<WeatherUiState>(
            WeatherUiState.Success(current.mapToModel())
        )
    }

    override suspend fun clearLocal() {
        database.weatherDao().clearData()
    }
}