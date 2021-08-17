package com.fjbg.weather.data.mapper

import com.fjbg.weather.data.local.WeatherEntity
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.remote.WeatherResponse


fun weatherResponseToEntity(response: WeatherResponse): WeatherEntity = WeatherEntity(
    id = 0,
    longitude = response.coord.lon,
    latitude = response.coord.lat,
    currentTemp = response.main.temp,
    weatherDescription = response.weather[0].description,
    weatherMain = response.weather[0].main,
    weatherIcon = response.weather[0].icon,
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

fun weatherEntityMapToModel(entity: WeatherEntity): WeatherDto {
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
