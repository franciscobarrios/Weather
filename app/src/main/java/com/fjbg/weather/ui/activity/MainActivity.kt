package com.fjbg.weather.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.lifecycleScope
import com.fjbg.weather.ui.theme.WeatherTheme
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

const val TAG = ">>>>>>>>>>>>>>>>"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.currentWeather.collect {
                Log.d(TAG, "onCreate: it: $it")
            }
        }
    }
}