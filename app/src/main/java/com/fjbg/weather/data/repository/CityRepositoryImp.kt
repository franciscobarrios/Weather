package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.WEATHER_KEY
import com.fjbg.weather.data.mapper.cityEntityListMapToDomain
import com.fjbg.weather.data.mapper.cityResponseListMapToDomain
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.di.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class CityRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    database: AppDatabase,
) : CityRepository {

    private val cityDao = database.cityDao()

    override suspend fun getCity(city: String): Flow<List<CityDto>?> {
        val data = MutableStateFlow<List<CityDto>?>(null)
        try {
            weatherService.getCity(city = city, limit = 5, apiKey = WEATHER_KEY)?.run {
                val list = this
                if (list.isNotEmpty()) {
                    data.value = cityResponseListMapToDomain(list)
                } else {
                    data.value = null
                }
            }
        } catch (e: Exception) {
            data.value = null
        }
        return data
    }

    override suspend fun clearAll() {
        cityDao.clearAll()
    }

    override suspend fun saveCity(city: CityDto) {
        cityDao.saveCity(city.mapToEntity())
    }

    override suspend fun getCitiesFromLocal(): Flow<List<CityDto>?> {
        val data = MutableStateFlow<List<CityDto>?>(null)
        cityDao.getCities()
            .distinctUntilChanged()
            .collect { list ->
            list?.run {
                data.value = cityEntityListMapToDomain(this)
            }

        }
        return data
    }
}