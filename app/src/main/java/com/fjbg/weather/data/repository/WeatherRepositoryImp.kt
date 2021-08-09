package com.fjbg.weather.data.repository

import com.fjbg.weather.data.local.WeatherDatabase
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.mapper.mapToModel
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.remote.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherService,
    private val database: WeatherDatabase,
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