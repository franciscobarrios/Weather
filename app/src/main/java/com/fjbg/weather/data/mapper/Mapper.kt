package com.fjbg.weather.data.mapper

import com.fjbg.weather.data.local.AqiEntity
import com.fjbg.weather.data.local.WeatherEntity
import com.fjbg.weather.data.model.AqiDto
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.remote.AqiResponse
import com.fjbg.weather.data.remote.WeatherResponse


fun weatherResponseToEntity(response: WeatherResponse): WeatherEntity = WeatherEntity(
    id = 0,
    longitude = response.coord.lon,
    latitude = response.coord.lat,
    currentTemp = response.main.temp,
    weatherDescription = response.weather[0].description,
    weatherMain = response.weather[0].main,
    weatherIcon = response.weather[0].icon,
    weatherIconId = response.weather[0].id,
    feelsLike = response.main.feels_like,
    tempMax = response.main.temp_max,
    tempMin = response.main.temp_min,
    pressure = response.main.pressure,
    humidity = response.main.humidity,
    windSpeed = response.wind.speed,
    windDirection = response.wind.deg,
    windGust = response.wind.gust,
    cloud = if (response.clouds == null) 0 else response.clouds.all,
    timezone = response.timezone,
    cityName = response.name,
    dt = response.dt,
    country = response.sys.country,
    sunrise = response.sys.sunrise,
    sunset = response.sys.sunset,
    visibility = response.visibility
)

fun weatherEntityToDomain(entity: WeatherEntity): WeatherDto {
    return WeatherDto(
        longitude = entity.longitude,
        latitude = entity.latitude,
        currentTemp = entity.currentTemp,
        feelsLike = entity.feelsLike,
        tempMax = entity.tempMax,
        tempMin = entity.tempMin,
        pressure = entity.pressure,
        humidity = entity.humidity,
        windSpeed = entity.windSpeed,
        windDirection = entity.windDirection,
        windGust = entity.windGust,
        cloud = entity.cloud,
        timezone = entity.timezone,
        name = entity.cityName,
        dt = entity.dt,
        country = entity.country,
        sunrise = entity.sunrise,
        sunset = entity.sunset,
        visibility = entity.visibility,
        weatherIcon = entity.weatherIcon,
        weatherIconId = entity.weatherIconId,
        weatherMain = entity.weatherMain,
        weatherDescription = entity.weatherDescription
    )
}

fun aqiResponseToEntity(response: AqiResponse): AqiEntity = AqiEntity(
    id = 0,
    aqi = response.data?.aqi ?: 0,
)

fun aqiEntityToDomain(entity: AqiEntity): AqiDto = AqiDto(
    id = entity.id,
    aqi = entity.aqi
)