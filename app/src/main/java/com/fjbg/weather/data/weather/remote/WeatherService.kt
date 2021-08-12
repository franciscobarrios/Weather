package com.fjbg.weather.data.weather.remote

import com.fjbg.weather.data.WEATHER_KEY
import retrofit2.http.GET

interface WeatherService {

    @GET("weather?q=Bangkok&appid=$WEATHER_KEY")
    suspend fun getWeather(): WeatherResponse
}