package com.fjbg.weather.data.repository

import com.fjbg.weather.data.model.CityDto
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun getCity(city: String): Flow<List<CityDto>?>
    suspend fun clearAll()
    suspend fun saveCity(city: CityDto)
    suspend fun getCitiesFromLocal(): Flow<List<CityDto>?>
}