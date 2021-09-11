package com.fjbg.weather.data.repository

import com.fjbg.weather.data.local.CityWeatherEntity
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.data.model.CityWeatherDto
import kotlinx.coroutines.flow.Flow

interface CityWeatherRepository {

    suspend fun completeCityWeatherInfo(city: CityDto)
    fun getCityWeatherList(): Flow<List<CityWeatherEntity>?>
    suspend fun saveCityWeather(cityWeather: CityWeatherEntity)
    suspend fun setCityAsFavorite(isFavorite: Boolean)
    suspend fun deleteCityWeather(cityWeatherId: Int)
}