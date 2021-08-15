package com.fjbg.weather.data.remote

sealed class NetworkResponse<out T : Any?> {
    data class Success<T : Any>(val data: T?) : NetworkResponse<T>()
    data class Error(val error: Throwable) : NetworkResponse<Throwable>()
}