package com.fjbg.weather.data.aqi.remote

import com.fjbg.weather.data.AQI_KEY
import com.fjbg.weather.data.WEATHER_KEY
import retrofit2.http.GET

interface AqiService {

    //@GET("bangkok/?token=$AQI_KEY")
    @GET("weather?q=Bangkok&appid=$WEATHER_KEY")
    suspend fun getAqi(): AqiResponse

}