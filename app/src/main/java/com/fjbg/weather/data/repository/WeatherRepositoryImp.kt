package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.mapper.mapToModel
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.di.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    private val database: AppDatabase,
) : WeatherRepository {

    override suspend fun getRemoteWeather() {
        val entity = weatherService.getWeather().mapToEntity()
        database.weatherDao().insertWeather(entity)
    }

    override suspend fun getCurrent(): Flow<WeatherDto?> {
        return database.weatherDao().getCurrentWeather().map { entity ->
            entity.mapToModel()
        }
    }

    override suspend fun updateLocal() {
    }

    override suspend fun clearLocal() {
        database.weatherDao().clearData()
    }
}