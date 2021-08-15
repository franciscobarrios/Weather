package com.fjbg.weather.data.remote

import com.fjbg.weather.data.AQI_KEY
import retrofit2.http.GET

interface AqiApi {

    @GET("bangkok/?token=$AQI_KEY")
    suspend fun getAqi(): AqiResponse

}