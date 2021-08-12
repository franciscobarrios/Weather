package com.fjbg.weather.data.aqi.repository

import com.fjbg.weather.data.aqi.remote.AqiResponse

interface AqiRepository {
    suspend fun getAqi(): AqiResponse
}