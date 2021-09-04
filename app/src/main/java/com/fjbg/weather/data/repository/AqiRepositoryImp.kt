package com.fjbg.weather.data.repository

import com.fjbg.weather.data.AQI_KEY
import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.mapper.aqiResponseToEntity
import com.fjbg.weather.data.remote.AqiApi
import com.fjbg.weather.data.remote.AqiResponse
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.di.AqiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AqiRepositoryImp @Inject constructor(
    @AqiService private val aqiService: AqiApi,
    database: AppDatabase,
) : AqiRepository {

    private val aqiDao = database.aqiDao()

    override suspend fun getRemoteAqi(): Flow<NetworkResponse<AqiResponse?>> {
        val entity = aqiService.getAqi(
            city = "Villarrica",
            token = AQI_KEY,
        )?.run {
            aqiResponseToEntity(this)
        }
        return when {
            entity != null -> {
                clearLocal()
                entity.let {
                    aqiDao.insertAqi(it)
                    return flowOf(NetworkResponse.Success(true))
                }
            }
            else -> flowOf(NetworkResponse.Error(Throwable("no data")))
        }
    }

    override suspend fun clearLocal() = aqiDao.clearData()

    override suspend fun getAqi(): Flow<Int?> = aqiDao.getCurrentAqi().distinctUntilChanged()

}