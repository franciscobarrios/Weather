package com.fjbg.weather.data.repository

import com.fjbg.weather.data.local.CityWeatherEntity
import com.fjbg.weather.data.model.CityDto
import kotlinx.coroutines.flow.Flow

interface CityWeatherRepository {

    suspend fun completeCityWeatherInfo(city: CityDto)
    fun getCityWeatherListFlow(): Flow<List<CityWeatherEntity>?>
    suspend fun saveCityWeather(cityWeather: CityWeatherEntity)
    suspend fun updateCurrentWeather(cityWeather: UpdateCityWeather)
    suspend fun setCityAsFavorite(isFavorite: Boolean)
    suspend fun deleteCityWeather(cityWeatherId: Int)
}