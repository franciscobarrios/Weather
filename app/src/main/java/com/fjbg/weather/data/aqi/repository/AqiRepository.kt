package com.fjbg.weather.data.aqi.repository

interface AqiRepository {
    suspend fun getAqi()
}