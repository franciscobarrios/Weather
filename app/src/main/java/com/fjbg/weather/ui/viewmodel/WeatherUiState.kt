package com.fjbg.weather.ui.viewmodel

import com.fjbg.weather.data.model.WeatherDto

sealed class WeatherUiState {

    data class Loading(val isLoading: Boolean) : WeatherUiState()
    data class Success(val data: WeatherDto) : WeatherUiState()
    data class Error(val error: Throwable) : WeatherUiState()
}