package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.viewmodel.WeatherViewModel

@ExperimentalMaterialApi
@Composable
fun MainView(
    viewModel: WeatherViewModel?,
    actionAddLocation: () -> Unit,
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

    Box(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF071A22),
                        Color(0xFF24263B),
                        Color(0xFF272A41),
                        Color(0xFF413D60),
                        Color(0xFF7E5E79),
                        Color(0xFFDE8A64),
                        Color(0xFF6D2F24),
                        Color(0xFF0C0B0E),
                    )
                )
            )
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
            )
            WeatherInfo(
                temp = "$currentTemp°c",
                description = description ?: "Thunderstorm",
                icon = icon
            )
            InfoCardSection(
                humidity = humidity ?: "89%",
                aqi = aqi ?: "46",
                wind = windSpeed ?: "12",
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
    )
}