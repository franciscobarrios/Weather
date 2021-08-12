package com.fjbg.weather.data.weather.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.mapper.mapToModel
import com.fjbg.weather.data.weather.model.WeatherDto
import com.fjbg.weather.data.weather.remote.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherService,
    private val database: AppDatabase,
) : WeatherRepository {

    override suspend fun getRemoteWeather() {
        val entity = service.getWeather().mapToEntity()
        database.weatherDao().insertWeather(entity)
    }

    override suspend fun getCurrent(): Flow<WeatherDto?> {
        return database.weatherDao().getCurrentWeather().map { entity ->
            entity.mapToModel()
        }
    }

    override suspend fun updateLocal() {
        TODO("Not yet implemented")
    }

    override suspend fun clearLocal() {
        database.weatherDao().clearData()
    }
}