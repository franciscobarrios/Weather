package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.viewmodel.WeatherViewModel

@ExperimentalMaterialApi
@Composable
fun MainView(
    viewModel: WeatherViewModel?,
    actionAddLocation: () -> Unit,
    timeOfTheDay: TimeOfTheDay,
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
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .background(dynamicBackground(timeOfTheDay))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
        ) {
            CityWeatherContent(
                city = city,
                country = country,
                date = date,
                currentTemp = currentTemp,
                description = description,
                icon = icon,
                humidity = humidity,
                aqi = aqi,
                windSpeed = windSpeed,
                indexUv = "",
                actionAddLocation = actionAddLocation
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun CityWeatherContent(
    city: String?,
    country: String?,
    date: String?,
    currentTemp: String?,
    description: String?,
    icon: Int?,
    humidity: String?,
    aqi: String?,
    windSpeed: String?,
    indexUv: String?,
    actionAddLocation: () -> Unit,
) {
    HeaderView(
        city = city,
        country = country,
        date = date,
        timeOfTheDay = TimeOfTheDay.DAY,
        actionAddLocation = actionAddLocation,
    )
    WeatherInfo(
        temperature = currentTemp,
        description = description,
        icon = icon,
        timeOfTheDay = TimeOfTheDay.DAY,
    )
    InfoCardSection(
        humidity = humidity,
        aqi = aqi,
        wind = windSpeed,
        indexUv = indexUv,
        timeOfTheDay = TimeOfTheDay.DAY,
    )
}


@ExperimentalMaterialApi
@Preview
@Composable
fun MainViewPreview() {
    MainView(
        viewModel = null,
        actionAddLocation = { },
        timeOfTheDay = TimeOfTheDay.DAY
    )
}