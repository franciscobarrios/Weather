package com.fjbg.weather.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.lifecycleScope
import com.fjbg.weather.data.TAG
import com.fjbg.weather.data.remote.NetworkResponse
import com.fjbg.weather.ui.theme.WeatherTheme
import com.fjbg.weather.ui.view.MainView
import com.fjbg.weather.ui.viewmodel.WeatherUiState
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainView(viewModel)
                }
            }
        }

        lifecycleScope.launchWhenResumed {
            viewModel.getCurrentTemperature().collect {
                Log.d(TAG, "getCurrentTemperature: $it")
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.fetchWeatherInfo.collect {
                when (it) {
                    is NetworkResponse.Loading -> Log.d(
                        TAG,
                        "fetchWeatherInfo: Loading: ${it.isLoading}"
                    )
                    is NetworkResponse.Success -> Log.d(
                        TAG,
                        "fetchWeatherInfo: Loading: ${it.data}"
                    )
                    is NetworkResponse.Error -> Log.d(TAG, "fetchWeatherInfo: Loading: ${it.error}")
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.currentWeather.collect {
                Log.d(TAG, "onCreate: it: $it")
                when (it) {
                    is WeatherUiState.Loading -> Log.d(
                        TAG,
                        "currentWeather: Loading: ${it.isLoading}"
                    )
                    is WeatherUiState.Success -> Log.d(
                        TAG,
                        "currentWeather: it - Success: ${it.data}"
                    )
                    is WeatherUiState.Error -> Log.d(TAG, "currentWeather: Error: ${it.error}")
                }
            }
        }
    }
}