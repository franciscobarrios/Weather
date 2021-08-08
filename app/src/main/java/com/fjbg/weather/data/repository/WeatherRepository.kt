package com.fjbg.weather.data.repository

interface WeatherRepository {
    suspend fun getCurrent()
    suspend fun getList()
    suspend fun updateLocal()
}