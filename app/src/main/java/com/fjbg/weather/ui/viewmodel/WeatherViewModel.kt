package com.fjbg.weather.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.weather.data.TAG
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.repository.AqiRepositoryImp
import com.fjbg.weather.data.repository.WeatherRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepositoryImp,
    private val aqiRepository: AqiRepositoryImp

) : ViewModel() {

    private val _currentWeather = MutableStateFlow<WeatherUiState?>(null)
    val currentWeather: StateFlow<WeatherUiState?> = _currentWeather

    init {
        viewModelScope.launch {
            weatherRepository.getRemoteWeather().collect {

            }
        }

        viewModelScope.launch {
            weatherRepository.getCurrent().collect { state ->
                when (state) {
                    is WeatherUiState.Loading -> _currentWeather.value =
                        WeatherUiState.Loading(state.isLoading)
                    is WeatherUiState.Success -> _currentWeather.value =
                        WeatherUiState.Success(state.data)
                    is WeatherUiState.Error -> _currentWeather.value =
                        WeatherUiState.Error(state.error)
                }
            }
        }

        viewModelScope.launch {
            aqiRepository.getAqi()
        }
    }
}