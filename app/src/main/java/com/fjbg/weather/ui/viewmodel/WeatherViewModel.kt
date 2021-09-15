package com.fjbg.weather.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.weather.data.mapper.cityWeatherEntitiesToDomain
import com.fjbg.weather.data.mapper.iconIdToIconWeather
import com.fjbg.weather.data.mapper.mapTimeOfTheDay
import com.fjbg.weather.data.mapper.owApiIconToIntResourceDay
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.data.model.CityWeatherDto
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.data.repository.AqiRepositoryImp
import com.fjbg.weather.data.repository.CityRepositoryImp
import com.fjbg.weather.data.repository.CityWeatherRepositoryImp
import com.fjbg.weather.data.repository.WeatherRepositoryImp
import com.fjbg.weather.ui.view.main.TimeOfTheDay
import com.fjbg.weather.util.getCountry
import com.fjbg.weather.util.oneDecimal
import com.fjbg.weather.util.toDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepositoryImp,
    private val cityRepository: CityRepositoryImp,
    private val aqiRepository: AqiRepositoryImp,
    private val cityWeatherRepository: CityWeatherRepositoryImp,
) : ViewModel() {

    private val _fetchWeatherInfo = MutableStateFlow<NetworkResponse<Any>?>(null)
    private val _currentWeather = MutableStateFlow<WeatherUiState?>(null)
    private val _fetchCity: MutableState<List<CityDto>?> = mutableStateOf(null)

    val country: MutableState<String?> = mutableStateOf(null)
    val cityName: MutableState<String?> = mutableStateOf(null)
    val date: MutableState<String?> = mutableStateOf(null)
    val resIconWeather: MutableState<Int?> = mutableStateOf(null)
    val currentTemperature: MutableState<String?> = mutableStateOf(null)
    val description: MutableState<String?> = mutableStateOf(null)
    val humidity: MutableState<String?> = mutableStateOf(null)
    val windSpeed: MutableState<String?> = mutableStateOf(null)
    val aqi: MutableState<String?> = mutableStateOf(null)
    val cityWeatherList: MutableState<List<CityWeatherDto>?> = mutableStateOf(null)
    val savedCityCount: MutableState<Int> = mutableStateOf(0)

    init {
        getCity()
        getCountry()
        getDate()
        getIcon()
        getCurrentTemperature()
        getDescription()
        getHumidity()
        getWindSpeed()
        getAqi()
        getCitiesFromLocal()
    }

    fun timeOfTheDay(): TimeOfTheDay {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return mapTimeOfTheDay(hour)
    }

    fun getCityList(): List<CityDto>? = _fetchCity.value

    fun searchCityByName(city: String) {
        viewModelScope.launch {
            cityRepository.getCity(city).collect { response ->
                if (response != null) {
                    updateCurrentCityWeather(response)
                    _fetchCity.value = response
                } else {
                    _fetchCity.value = null
                }
            }
        }
    }

    private fun updateCurrentCityWeather(list: List<CityDto>) {
        viewModelScope.launch {
            cityWeatherRepository.getCurrentWeatherPerCity(list)
        }
    }

    fun saveCity(city: CityDto) {
        viewModelScope.launch {
            cityRepository.saveCity(city)
            cityWeatherRepository.completeCityWeatherInfo(city)
        }
    }

    private fun getCitiesFromLocal() {
        viewModelScope.launch {
            cityWeatherRepository.getCityWeatherListFlow()
                .distinctUntilChanged()
                .collectLatest { list ->
                    list?.let {
                        cityWeatherList.value = cityWeatherEntitiesToDomain(it)
                        savedCityCount.value = it.size
                    }
                }
        }
    }

    fun deleteCity(city: CityDto) {
        viewModelScope.launch {
            cityRepository.deleteCity(city)
        }
    }

    private fun getDate() {
        viewModelScope.launch {
            weatherRepository.getDate().collect {
                it?.run {
                    //Log.d(TAG, "getDate: ${this.toDate()}")
                    date.value = this.toDate()
                }
            }
        }
    }

    private fun getCountry() {
        viewModelScope.launch {
            weatherRepository.getCountry().collect {
                it?.run {
                    //Log.d(TAG, "getCountry: ${Locale("en", this).displayCountry}")
                    country.value = this.getCountry()
                }
            }
        }
    }

    private fun getCity() {
        viewModelScope.launch {
            weatherRepository.getCity().collect {
                //Log.d(TAG, "getCity: $it")
                cityName.value = it
            }
        }
    }

    private fun getIcon() {
        viewModelScope.launch {
            weatherRepository.getIconId().collect {
                it?.run {
                    val iconWeather = iconIdToIconWeather(it)
                    val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
                    iconWeather?.let { icon ->
                        resIconWeather.value = owApiIconToIntResourceDay(icon, currentTime > 18)
                    }
                }
            }
        }
    }

    private fun getCurrentTemperature() {
        viewModelScope.launch {
            weatherRepository.getCurrentTemperature().collect {
                //Log.d(TAG, "getCurrentTemperature: $it")
                it?.run {
                    currentTemperature.value = (this - 273).toInt().toString()
                }
            }
        }
    }

    private fun getDescription() {
        viewModelScope.launch {
            weatherRepository.getDescription().collect {
                //Log.d(TAG, "getDescription: $it")
                description.value = it
            }
        }
    }

    private fun getWindSpeed() {
        viewModelScope.launch {
            weatherRepository.getWindSpeed().collect {
                it?.run {
                    windSpeed.value = this.oneDecimal().toString()
                }
            }
        }
    }

    private fun getHumidity() {
        viewModelScope.launch {
            weatherRepository.getHumidity().collect {
                it?.run {
                    humidity.value = this.toInt().toString()
                }
            }
        }
    }

    private fun getAqi() {
        viewModelScope.launch {
            aqiRepository.getAqi().collect {
                it?.run {
                    aqi.value = this.toString()
                }
            }
        }
    }
}