package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.WEATHER_KEY
import com.fjbg.weather.data.local.CityEntity
import com.fjbg.weather.data.mapper.cityResponseListMapToDomain
import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.di.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CityRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    database: AppDatabase,
) : CityRepository {

    private val cityDao = database.cityDao()
    private val cityWeatherDao = database.cityWeatherDao()

    override suspend fun getCity(city: String): Flow<List<CityDto>?> {
        val data = MutableStateFlow<List<CityDto>?>(null)
        try {
            weatherService.getCity(
                city = city,
                limit = 5,
                apiKey = WEATHER_KEY,
            )?.run {
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

    override suspend fun deleteCity(city: CityDto) {
        cityDao.deleteCityById(city.id)
    }

    override suspend fun clearAll() {
        cityDao.clearAll()
    }

    override suspend fun saveCity(city: CityDto) {
        cityDao.saveCity(city.mapToEntity())
    }

    override suspend fun getCitiesFromLocal(): Flow<List<CityEntity>?> {
        return cityDao.getCities()
    }
}