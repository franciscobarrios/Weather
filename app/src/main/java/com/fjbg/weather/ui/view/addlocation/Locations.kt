package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.*

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun LocationView(
    viewModel: WeatherViewModel?,
    searchLocation: () -> Unit,
    timeOfTheDay: TimeOfTheDay
) {
    val cityWeatherList = viewModel?.cityWeatherList?.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dynamicBackground(timeOfTheDay)),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(12.dp)
            ) {
                cityWeatherList?.let { cityWeather ->
                    items(count = cityWeatherList.size) {
                        CityWeatherWidget(
                            temperature = cityWeather[it].temperature.oneDecimal().toString(),
                            city = cityWeather[it].city,
                            country = cityWeather[it].country,
                            humidity = cityWeather[it].humidity.oneDecimal().toString(),
                            wind = cityWeather[it].wind.oneDecimal().toString(),
                            timeOfTheDay = TimeOfTheDay.NIGHT
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = { searchLocation.invoke() },
            modifier = Modifier.padding(24.dp),
            backgroundColor = dynamicFabColor(timeOfTheDay),
            contentColor = dynamicFabContentColor(timeOfTheDay),
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add new location"
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview
@Composable
fun LocationViewPreview() {
    LocationView(
        viewModel = null,
        searchLocation = {},
        timeOfTheDay = TimeOfTheDay.DAY
    )
}