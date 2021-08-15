package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.remote.AqiApi
import com.fjbg.weather.di.AqiService
import javax.inject.Inject

class AqiRepositoryImp @Inject constructor(
    @AqiService private val aqiService: AqiApi,
    private val database: AppDatabase,
) : AqiRepository {
    override suspend fun getAqi() {
        aqiService.getAqi()
    }
}