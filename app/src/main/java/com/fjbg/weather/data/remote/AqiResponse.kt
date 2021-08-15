package com.fjbg.weather.data.remote

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class AqiResponse(
    val status: String,
    val data: AqiData?,
)

data class AqiData(
    val aqi: Int,
    val idx: Int,
    val city: AqiCity,
    val time: AqiTime,
    val iaqi: Iaqi,
)

data class AqiTime(
    val s: String,
    val tz: String,
)

data class AqiCity(
    val name: String,
    val geo: List<Double>,
    val url: String,
)

data class Iaqi(
    val co: JsonObject,
    val h: JsonObject,
    val no2: JsonObject,
    val o3: JsonObject,
    val p: JsonObject,
    val pm10: JsonObject,
    val pm25: JsonObject,
    val so2: JsonObject,
    val w: JsonObject,
)

data class Attributions(
    val array: JsonArray,
)
