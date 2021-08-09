package com.fjbg.weather.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.weather.data.model.WeatherDto
import com.fjbg.weather.data.repository.WeatherRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepositoryImp
) : ViewModel() {

    private val _currentWeather = MutableStateFlow<WeatherDto?>(null)
    val currentWeather: StateFlow<WeatherDto?> = _currentWeather

    init {
        viewModelScope.launch {
            repository.getRemoteWeather()
        }

        viewModelScope.launch {
            repository.getCurrent().collect {
                _currentWeather.value = it
            }
        }
    }
}