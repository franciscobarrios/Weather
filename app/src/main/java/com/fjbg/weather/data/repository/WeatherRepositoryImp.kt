package com.fjbg.weather.data.repository

import android.util.Log
import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.TAG
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.mapper.mapToModel
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.di.WeatherService
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    private val database: AppDatabase,
) : WeatherRepository {

    override suspend fun getRemoteWeather(): Flow<WeatherResponse?> {
        val entity = weatherService.getWeather()?.mapToEntity()
        database.weatherDao().clearData()
        entity?.let {
            database.weatherDao().insertWeather(it)
        }
        return flowOf()
    }

    override suspend fun getCurrent(): Flow<WeatherUiState?> {

        Log.d(TAG, "getCurrent")

        val data = MutableStateFlow<WeatherUiState?>(null)

        database.weatherDao().getCurrentWeather().map { entity ->

            Log.d(TAG, "getCurrent: entity $entity")

            data.value = WeatherUiState.Success(entity.mapToModel())
        }
        return data
    }

    override suspend fun updateLocal() {
    }

    override suspend fun clearLocal() {
        database.weatherDao().clearData()
    }
}