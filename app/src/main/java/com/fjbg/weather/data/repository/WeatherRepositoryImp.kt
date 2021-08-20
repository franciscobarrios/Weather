package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.mapper.iconMapper
import com.fjbg.weather.data.mapper.weatherEntityMapToModel
import com.fjbg.weather.data.mapper.weatherResponseToEntity
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.di.WeatherService
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import com.fjbg.weather.util.toDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import java.util.*
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    database: AppDatabase,
) : WeatherRepository {

    private val weatherDao = database.weatherDao()

    override suspend fun getRemoteWeather(): Flow<NetworkResponse<WeatherResponse?>> {
        val entity = weatherService.getWeather()?.run {
            weatherResponseToEntity(this)
        }
        return when {
            entity != null -> {
                clearLocal()
                entity.let { weatherDao.insertWeather(it) }
                return flowOf(NetworkResponse.Success(true))
            }
            else -> flowOf(NetworkResponse.Error(Throwable("no data")))
        }
    }

    override suspend fun getCurrent(): Flow<WeatherUiState?> {
        val data = MutableStateFlow<WeatherUiState?>(null)
        weatherDao.getCurrentWeather()?.run {
            data.value = WeatherUiState.Success(weatherEntityMapToModel(this))
        }
        return data
    }

    override suspend fun clearLocal() = weatherDao.clearData()

    override suspend fun getCurrentTemperature(): Flow<Double?> =
        flowOf(weatherDao.getCurrentTemperature())

    override suspend fun getHumidity(): Flow<Double?> = flowOf(weatherDao.getHumidity())

    override suspend fun getDescription(): Flow<String?> = flowOf(weatherDao.getDescription())

    override suspend fun getDescriptionMain(): Flow<String?> =
        flowOf(weatherDao.getDescriptionMain())

    override suspend fun getCity(): Flow<String?> = flowOf(weatherDao.getCity())

    override suspend fun getCountry(): Flow<String?> {
        val data = MutableStateFlow("")
        weatherDao.getCountry()?.let {
            data.value = Locale("en", it).displayCountry
        }
        return data
    }

    override suspend fun getIcon(): Flow<String?> {

        weatherDao.getIconId()?.let {
            val icon = iconMapper(it)
            icon
        }

        return flowOf("")
    }

    override suspend fun getDate(): Flow<String?> {
        return flowOf(weatherDao.getDate()?.toDate())
    }
}


