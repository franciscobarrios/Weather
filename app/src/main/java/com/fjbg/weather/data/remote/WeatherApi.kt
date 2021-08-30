package com.fjbg.weather.data.remote

import com.fjbg.weather.data.WEATHER_KEY
import retrofit2.http.GET

interface WeatherApi {

    @GET("data/2.5/weather?q=Bangkok&appid=$WEATHER_KEY")
    suspend fun getWeather(): WeatherResponse?


    @GET("geo/1.0/direct?q=Villarrica&limit=5&appid=$WEATHER_KEY")
    suspend fun getCity(): List<CityResponse>
}