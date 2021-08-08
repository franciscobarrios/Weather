package com.fjbg.weather.data.repository

import com.fjbg.weather.data.mapper.mapToEntity
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.remote.WeatherService
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherService,
) : WeatherRepository {

    override suspend fun getRemoteWeather() {
        val entity = service.getWeather().mapToEntity()
        //weatherDao.insertWeather(entity)
    }

    override suspend fun getCurrent(): WeatherDto {
        TODO("Not yet implemented")
    }

    override suspend fun updateLocal() {
        TODO("Not yet implemented")
    }

    override suspend fun clearLocal() {
        TODO("Not yet implemented")
    }

}