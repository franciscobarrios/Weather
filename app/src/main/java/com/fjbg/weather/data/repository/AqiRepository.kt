package com.fjbg.weather.data.repository

import com.fjbg.weather.data.remote.AqiResponse
import com.fjbg.weather.data.remote.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface AqiRepository {
    suspend fun getRemoteAqi(): Flow<NetworkResponse<AqiResponse?>>
    suspend fun clearLocal()
    suspend fun getAqi():Flow<Int?>
}