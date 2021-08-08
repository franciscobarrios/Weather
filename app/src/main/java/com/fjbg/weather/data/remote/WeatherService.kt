package com.fjbg.weather.data.remote

import com.fjbg.weather.data.BASE_URL
import com.fjbg.weather.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("weather?q=Bangkok&appid={key}")
    suspend fun getWeather(
        @Path("key") key: String? = BASE_URL,
    ): WeatherResponse
}