package com.fjbg.weather.data.mapper

import com.fjbg.weather.data.weather.local.WeatherEntity
import com.fjbg.weather.data.weather.model.WeatherDto
import com.fjbg.weather.data.weather.remote.WeatherResponse

fun WeatherResponse.mapToEntity(): WeatherEntity {
    val response = this
    return WeatherEntity(
        id = 0,
        longitude = response.coord.lon,
        latitude = response.coord.lat,
        currentTemp = response.main.temp,
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
        name = response.name,
        dt = response.dt,
        visibility = response.visibility
    )
}

fun WeatherEntity.mapToModel(): WeatherDto {
    val entity = this
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
        name = entity.name,
        dt = entity.dt,
        visibility = entity.visibility
    )
}