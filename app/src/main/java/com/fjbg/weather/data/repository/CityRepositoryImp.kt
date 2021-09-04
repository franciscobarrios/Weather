package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.WEATHER_KEY
import com.fjbg.weather.data.remote.CityResponse
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.di.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class CityRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    database: AppDatabase,
) : CityRepository {

    private val cityDao = database.cityDao()

    override suspend fun getCity(): Flow<NetworkResponse<List<CityResponse>>> {
        weatherService.getCity(
            city = "villarrica",
            limit = 5,
            apiKey = WEATHER_KEY,
        ).run {
            return run {
                flowOf(NetworkResponse.Success(this))
            }
        }
    }

    override suspend fun clearAll() {
        cityDao.clearAll()
    }
}