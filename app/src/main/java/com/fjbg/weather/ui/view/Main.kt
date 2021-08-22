package com.fjbg.weather.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.viewmodel.WeatherViewModel

@Composable
fun MainView(viewModel: WeatherViewModel?) {

    val country = viewModel?.country?.value
    val city = viewModel?.cityName?.value
    val date = viewModel?.date?.value
    val currentTemp = viewModel?.currentTemperature?.value
    val humidity = viewModel?.humidity?.value
    val windSpeed = viewModel?.windSpeed?.value
    val description = viewModel?.description?.value
    val icon = viewModel?.resIconWeather?.value

    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFDADADA)
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
                date = date
            )
            WeatherInfo(
                temp = "$currentTemp°",
                description = description ?: "Thunderstorm",
                humidity = "$humidity%",
                icon = icon
            )
            InfoCardSection(
                humidity = humidity.toString(),
                indexUv = "12",
                aqi = "46",
                wind = windSpeed.toString()
            )
        }
    }
}

@Preview
@Composable
fun MainViewPreview() {
    MainView(null)
}