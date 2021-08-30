package com.fjbg.weather.data.repository

import com.fjbg.weather.data.remote.CityResponse
import com.fjbg.weather.data.remote.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun getCity(): Flow<NetworkResponse<List<CityResponse>>>
    suspend fun clearAll()
}