package com.fjbg.weather.data.remote

sealed class NetworkResponse<out T : Any?> {
    data class Loading(val isLoading: Boolean) : NetworkResponse<Nothing>()
    data class Success<T>(val data: Any?) : NetworkResponse<T>()
    data class Error(val error: Throwable) : NetworkResponse<Nothing>()
}