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
                    MainView()
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.currentWeather.collect {
                Log.d(TAG, "onCreate: it: $it")

                when (it) {
                    is WeatherUiState.Loading -> Log.d(TAG, "onCreate: Loading: ${it.isLoading}")
                    is WeatherUiState.Success -> Log.d(TAG, "onCreate: it - Success: ${it.data}")
                    is WeatherUiState.Error -> Log.d(TAG, "onCreate: Error: ${it.error}")
                }
            }
        }
    }
}