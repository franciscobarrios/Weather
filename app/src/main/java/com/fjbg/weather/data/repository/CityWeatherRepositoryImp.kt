package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.WEATHER_KEY
import com.fjbg.weather.data.local.CityWeatherEntity
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.data.model.CityWeatherDto
import com.fjbg.weather.data.remote.WeatherApi
import com.fjbg.weather.di.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CityWeatherRepositoryImp @Inject constructor(
    @WeatherService private val weatherService: WeatherApi,
    database: AppDatabase,
) : CityWeatherRepository {

    private val cityWeatherDao = database.cityWeatherDao()

    override suspend fun completeCityWeatherInfo(city: CityDto) {
        val data = MutableStateFlow<List<CityWeatherDto>?>(null)
        try {
            weatherService.getCityWeather(
                lat = city.lat,
                lon = city.lon,
                units = "metrics",
                lang = "en",
                apiKey = WEATHER_KEY,
            )?.let { response ->
                saveCityWeather(
                    CityWeatherEntity(
                        id = 0,
                        city = response.name,
                        country = response.sys.country,
                        temperature = response.main.temp.toDouble(),
                        humidity = response.main.humidity.toDouble(),
                        wind = response.wind.speed.toDouble(),
                        active = true,
                        isFavorite = false,
                        icon = response.weather[0].id
                    )
                )
            }
        } catch (e: Exception) {

        }
    }

    suspend fun getCurrentWeatherPerCity(list: List<CityDto>) {
        list.forEach { cityDto ->
            weatherService.getWeather(
                city = cityDto.name,
                units = "metrics",
                lang = "en",
                apiKey = WEATHER_KEY,
            ).let { response ->
                response?.let {
                    updateCurrentWeather(
                        UpdateCityWeather(
                            id = cityDto.id,
                            temperature = (response.main.temp.toDouble()),
                            humidity = response.main.humidity.toDouble(),
                            wind = response.wind.speed.toDouble(),
                            icon = response.weather[0].id
                        )
                    )
                }
            }
        }
    }

    override fun getCityWeatherList(): Flow<List<CityWeatherEntity>?> =
        cityWeatherDao.getCityWeatherList()

    override suspend fun saveCityWeather(cityWeather: CityWeatherEntity) {
        cityWeather.apply {
            temperature -= 273
        }
        cityWeatherDao.saveCityWeather(cityWeather)
    }

    override suspend fun updateCurrentWeather(cityWeather: UpdateCityWeather) {
        cityWeatherDao.updateCurrentWeather(
            id = cityWeather.id,
            temperature = cityWeather.temperature,
            humidity = cityWeather.humidity,
            wind = cityWeather.wind
        )
    }

    override suspend fun setCityAsFavorite(isFavorite: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCityWeather(cityWeatherId: Int) {
        TODO("Not yet implemented")
    }
}

data class UpdateCityWeather(
    val id: Int,
    val temperature: Double,
    val humidity: Double,
    val wind: Double,
    val icon: Int,
    val active: Boolean? = null,
    val isFavorite: Boolean? = null
)