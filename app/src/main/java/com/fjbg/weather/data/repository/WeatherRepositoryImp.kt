package com.fjbg.weather.data.repository

import com.fjbg.weather.data.model.WeatherResponse
import com.fjbg.weather.data.remote.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherService
) : WeatherRepository {

    suspend fun getRemoteWeather(): Flow<WeatherResponse> {
        return flowOf(service.getWeather())
    }

    override suspend fun getCurrent() {
    }

    override suspend fun getList() {
    }

    override suspend fun updateLocal() {
    }

}