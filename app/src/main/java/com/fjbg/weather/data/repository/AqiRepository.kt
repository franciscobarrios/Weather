package com.fjbg.weather.data.repository

interface AqiRepository {
    suspend fun getAqi()
}