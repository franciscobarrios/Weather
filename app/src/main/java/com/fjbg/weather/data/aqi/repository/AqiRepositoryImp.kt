package com.fjbg.weather.data.aqi.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.aqi.remote.AqiResponse
import com.fjbg.weather.data.aqi.remote.AqiService
import javax.inject.Inject

class AqiRepositoryImp @Inject constructor(
    private val aqiService: AqiService,
    private val database: AppDatabase,
) : AqiRepository {
    override suspend fun getAqi(): AqiResponse {
        TODO("Not yet implemented")
    }
}