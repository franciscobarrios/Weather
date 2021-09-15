package com.fjbg.weather.data.mapper

import com.fjbg.weather.data.local.AqiEntity
import com.fjbg.weather.data.local.CityEntity
import com.fjbg.weather.data.local.CityWeatherEntity
import com.fjbg.weather.data.local.WeatherEntity
import com.fjbg.weather.data.model.AqiDto
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.data.model.CityWeatherDto
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.remote.AqiResponse
import com.fjbg.weather.data.remote.CityResponse
import com.fjbg.weather.data.remote.WeatherResponse
import com.fjbg.weather.ui.view.main.TimeOfTheDay

// Weather
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

// City
fun mapToEntity(response: CityResponse): CityEntity =
    CityEntity(
        id = 0,
        name = response.name,
        country = response.country,
        lat = response.lat,
        lon = response.lon
    )

fun mapEntityToDomain(entity: CityEntity): CityDto =
    CityDto(
        id = entity.id,
        name = entity.name,
        country = entity.country,
        lat = entity.lat,
        lon = entity.lon
    )

fun CityDto.mapToEntity(): CityEntity =
    CityEntity(
        id = 0,
        name = this.name,
        country = this.country,
        lat = this.lat,
        lon = this.lon
    )


fun citiResponseMapToDomain(response: CityResponse): CityDto {
    return CityDto(
        id = -1,
        name = response.name,
        country = response.country,
        lat = response.lat,
        lon = response.lon
    )
}

fun cityResponseListMapToEntities(list: List<CityResponse>): List<CityEntity> =
    list.map(::mapToEntity)

fun cityEntityListMapToDomain(list: List<CityEntity>): List<CityDto> =
    list.map(::mapEntityToDomain)

fun cityResponseListMapToDomain(list: List<CityResponse>): List<CityDto> =
    list.map(::citiResponseMapToDomain)

fun cityWeatherDomainToEntity(cityWeather: CityWeatherDto): CityWeatherEntity {
    return CityWeatherEntity(
        id = 0,
        city = cityWeather.city,
        country = cityWeather.country,
        temperature = cityWeather.temperature,
        humidity = cityWeather.humidity,
        wind = cityWeather.wind,
        icon = cityWeather.icon,
        active = cityWeather.active,
        isFavorite = cityWeather.isFavorite,
        timeOfTheDay = 1
    )
}

fun cityWeatherDtoToEntity(cityWeather: CityWeatherDto): CityWeatherEntity =
    CityWeatherEntity(
        id = 0,
        city = cityWeather.city,
        country = cityWeather.country,
        temperature = cityWeather.temperature,
        humidity = cityWeather.humidity,
        wind = cityWeather.wind,
        icon = cityWeather.icon,
        active = cityWeather.active,
        isFavorite = cityWeather.isFavorite,
        timeOfTheDay = 1
    )

fun cityWeatherEntityToDomain(entity: CityWeatherEntity): CityWeatherDto =
    CityWeatherDto(
        id = entity.id,
        city = entity.city,
        country = entity.country,
        temperature = entity.temperature,
        humidity = entity.humidity,
        wind = entity.wind,
        icon = entity.icon,
        active = entity.active,
        isFavorite = entity.isFavorite
    )

fun cityWeatherEntitiesToDomain(list: List<CityWeatherEntity>): List<CityWeatherDto> =
    list.map(::cityWeatherEntityToDomain)

fun mapTimeOfTheDay(hour: Int): TimeOfTheDay {
    return when {
        (hour in 0..4) -> TimeOfTheDay.NIGHT
        (hour in 5..8) -> TimeOfTheDay.DAWN
        (hour in 9..17) -> TimeOfTheDay.DAY
        (hour in 18..21) -> TimeOfTheDay.DUSK
        (hour in 22..23) -> TimeOfTheDay.NIGHT
        else -> TimeOfTheDay.NIGHT
    }
}

