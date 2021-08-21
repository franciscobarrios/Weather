package com.fjbg.weather.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.weather.data.TAG
import com.fjbg.weather.data.mapper.iconIdToIconWeather
import com.fjbg.weather.data.mapper.owApiIconToIntResourceDay
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.repository.AqiRepositoryImp
import com.fjbg.weather.data.repository.WeatherRepositoryImp
import com.fjbg.weather.util.toDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepositoryImp,
    private val aqiRepository: AqiRepositoryImp,
) : ViewModel() {

    private val _fetchWeatherInfo = MutableStateFlow<NetworkResponse<Any>?>(null)
    private val _currentWeather = MutableStateFlow<WeatherUiState?>(null)

    val country: MutableState<String?> = mutableStateOf(null)
    val cityName: MutableState<String?> = mutableStateOf(null)
    val date: MutableState<String?> = mutableStateOf(null)
    val currentTemperature: MutableState<Int?> = mutableStateOf(null)
    val description: MutableState<String?> = mutableStateOf(null)
    val humidity: MutableState<Int?> = mutableStateOf(null)
    val windSpeed: MutableState<Int?> = mutableStateOf(null)
    val resIconWeather: MutableState<Int?> = mutableStateOf(null)

    init {
        viewModelScope.launch {
            aqiRepository.getAqi()
        }

        viewModelScope.launch {
            getCurrentTemperature()
            getHumidity()
            getWindSpeed()
            getDescription()
            getCity()
            getCountry()
            getDate()
            getIcon()
        }

        viewModelScope.launch {
            weatherRepository.getRemoteWeather().collect { response ->
                when (response) {
                    is NetworkResponse.Loading -> _fetchWeatherInfo.value =
                        NetworkResponse.Loading(true)
                    is NetworkResponse.Success -> _fetchWeatherInfo.value =
                        NetworkResponse.Success(response.data)
                    is NetworkResponse.Error -> _fetchWeatherInfo.value =
                        NetworkResponse.Error(response.error)
                }
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
    }

    private fun getIcon() {
        viewModelScope.launch {
            weatherRepository.getIconId().collect { it ->
                it?.run {
                    val iconWeather = iconIdToIconWeather(it)
                    val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
                    iconWeather?.let { icon ->
                        resIconWeather.value = owApiIconToIntResourceDay(icon, currentTime > 19)
                    }
                }
            }
        }
    }

    private fun getDate() {
        viewModelScope.launch {
            weatherRepository.getDate().collect {
                it?.run {
                    Log.d(TAG, "getDate: ${this.toDate()}")
                    date.value = this.toDate()
                }
            }
        }
    }

    private fun getCountry() {
        viewModelScope.launch {
            weatherRepository.getCountry().collect {
                it?.run {
                    Log.d(TAG, "getCountry: ${Locale("en", this).displayCountry}")
                    country.value = Locale("en", this).displayCountry
                }
            }
        }
    }

    private suspend fun getCity() {
        viewModelScope.launch {
            weatherRepository.getCity().collect {
                Log.d(TAG, "getCity: $it")
                cityName.value = it
            }
        }
    }

    private suspend fun getCurrentTemperature() {
        viewModelScope.launch {
            weatherRepository.getCurrentTemperature().collect {
                Log.d(TAG, "getCurrentTemperature: $it")
                it?.run {
                    currentTemperature.value = this.toInt() / 10
                }
            }
        }
    }

    private suspend fun getWindSpeed() {
        viewModelScope.launch {
            weatherRepository.getWindSpeed().collect {
                it?.run {
                    windSpeed.value = this.toInt()
                }
            }
        }
    }

    private suspend fun getHumidity() {
        viewModelScope.launch {
            weatherRepository.getHumidity().collect {
                Log.d(TAG, "getHumidity: $it")
                it?.run {
                    humidity.value = this.toInt()
                }
            }
        }
    }

    private suspend fun getDescription() {
        viewModelScope.launch {
            weatherRepository.getDescription().collect {
                Log.d(TAG, "getDescription: $it")
                description.value = it
            }
        }
    }
}