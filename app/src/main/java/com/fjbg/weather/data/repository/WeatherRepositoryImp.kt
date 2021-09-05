package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.NO_DATA
import com.fjbg.weather.data.WEATHER_KEY
import com.fjbg.weather.data.mapper.weatherEntityToDomain
import com.fjbg.weather.data.mapper.weatherResponseToEntity
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.di.WeatherService
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    database: AppDatabase,
) : WeatherRepository {

    private val weatherDao = database.weatherDao()

    override suspend fun getRemoteWeather(): Flow<NetworkResponse<WeatherResponse?>> {
        val entity = weatherService.getWeather(
            city = "Bangkok",
            apiKey = WEATHER_KEY
        )?.run {
            weatherResponseToEntity(this)
        }
        return when {
            entity != null -> {
                clearLocal()
                entity.let { weatherDao.insertWeather(it) }
                return flowOf(NetworkResponse.Success(true))
            }
            else -> flowOf(NetworkResponse.Error(Throwable(NO_DATA)))
        }
    }

    override suspend fun getCurrent(): Flow<WeatherUiState?> {
        val data = MutableStateFlow<WeatherUiState?>(null)
        weatherDao.getCurrentWeather()?.run {
            data.value = WeatherUiState.Success(weatherEntityToDomain(this))
        }
        return data
    }

    override suspend fun clearLocal() = weatherDao.clearData()

    override suspend fun getCurrentTemperature(): Flow<Float?> =
        weatherDao.getCurrentTemperature().distinctUntilChanged()

    override suspend fun getHumidity(): Flow<Float?> =
        weatherDao.getHumidity().distinctUntilChanged()

    override suspend fun getWindSpeed(): Flow<Float?> =
        weatherDao.getWindSpeed().distinctUntilChanged()

    override suspend fun getDescription(): Flow<String?> =
        weatherDao.getDescription().distinctUntilChanged()

    override suspend fun getDescriptionMain(): Flow<String?> =
        weatherDao.getDescriptionMain().distinctUntilChanged()

    override suspend fun getCity(): Flow<String?> =
        weatherDao.getCity().distinctUntilChanged()

    override suspend fun getCountry(): Flow<String?> =
        weatherDao.getCountry().distinctUntilChanged()

    override suspend fun getIcon(): Flow<String?> =
        weatherDao.getIcon().distinctUntilChanged()

    override suspend fun getIconId(): Flow<Int?> =
        weatherDao.getIconId().distinctUntilChanged()

    override suspend fun getDate(): Flow<Long?> =
        weatherDao.getDate().distinctUntilChanged()
}


