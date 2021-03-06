package com.fjbg.weather.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
//&units=metric
    @GET("data/2.5/weather?")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units:String,
        @Query("lang") lang:String,
        @Query("appid") apiKey: String,
    ): WeatherResponse?

    @GET("geo/1.0/direct?")
    suspend fun getCity(
        @Query("q") city: String,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String,
    ): List<CityResponse>?

    @GET("data/2.5/weather?")
    suspend fun getCityWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units:String,
        @Query("lang") lang:String,
        @Query("appid") apiKey: String,
    ): WeatherResponse?
}