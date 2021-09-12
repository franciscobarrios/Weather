package com.fjbg.weather.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import com.fjbg.weather.WeatherComposeApp
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    val viewModel: WeatherViewModel by viewModels()

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContent {
            WeatherComposeApp(viewModel = viewModel)
        }
    }
}