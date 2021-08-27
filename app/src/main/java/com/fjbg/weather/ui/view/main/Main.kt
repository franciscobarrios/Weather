package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.animation.NightSky
import com.fjbg.weather.ui.view.HeaderView
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.backgroundBrush
import kotlin.time.ExperimentalTime

@ExperimentalMaterialApi
@Composable
fun MainView(
    viewModel: WeatherViewModel?,
    actionAddLocation: () -> Unit,
    actionLocationList: () -> Unit,
) {
    val country = viewModel?.country?.value
    val city = viewModel?.cityName?.value
    val date = viewModel?.date?.value
    val currentTemp = viewModel?.currentTemperature?.value
    val humidity = viewModel?.humidity?.value
    val windSpeed = viewModel?.windSpeed?.value
    val description = viewModel?.description?.value
    val icon = viewModel?.resIconWeather?.value
    val aqi = viewModel?.aqi?.value

    if (isSystemInDarkTheme())
        Box(
            modifier = Modifier
                .background(backgroundBrush(isSystemInDarkTheme()))
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                HeaderView(
                    city = city,
                    country = country,
                    date = date,
                    actionAddLocation = actionAddLocation,
                    actionLocationList = actionLocationList,
                )
                WeatherInfo(
                    temp = "$currentTemp°c",
                    description = description ?: "Thunderstorm",
                    icon = icon
                )
                InfoCardSection(
                    humidity = humidity,
                    aqi = aqi,
                    wind = windSpeed,
                    indexUv = "12"
                )
            }
        }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun MainViewPreview() {
    MainView(
        viewModel = null,
        actionAddLocation = { },
        actionLocationList = { },
    )
}