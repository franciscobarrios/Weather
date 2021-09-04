package com.fjbg.weather.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AqiApi {

    @GET("{city}/?")
    suspend fun getAqi(
        @Path("city") city: String,
        @Query("token") token: String,
    ): AqiResponse?

}