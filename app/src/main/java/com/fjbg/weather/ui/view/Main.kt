package com.fjbg.weather.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.viewmodel.WeatherViewModel


@Composable
fun MainView(viewModel: WeatherViewModel) {

    val country = viewModel.country.value
    val city = viewModel.cityName.value
    val date = viewModel.date.value
    val currentTemp = viewModel.currentTemperature.value
    val humidity = viewModel.humidity.value
    val description = viewModel.description.value

    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PlaceName(
                city = city ?: "",
                country = country ?: "",
                date = date ?: "",
            )
            WeatherIcon()
            WeatherInfo(
                temp = "$currentTemp°",
                description = description ?: "",
                humidity = "$humidity%",
            )
        }
    }
}