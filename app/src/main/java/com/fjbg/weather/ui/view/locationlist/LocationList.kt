package com.fjbg.weather.ui.view.locationlist

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.theme.titleTextStyle
import com.fjbg.weather.ui.view.ItemCity
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.backgroundBrush

@ExperimentalMaterialApi
@Composable
fun LocationListView(
    viewModel: WeatherViewModel? = null,
    actionGoBack: () -> Unit
) {

    val cityList = viewModel?.citiesFromLocal?.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush(isSystemInDarkTheme()))
    ) {
        Column {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            Text(
                text = "Cities",
                style = titleTextStyle(isSystemInDarkTheme()),
                modifier = Modifier
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        top = 32.dp,
                        bottom = 16.dp
                    )
                    .fillMaxWidth()
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(12.dp)
            ) {
                cityList?.let { cities ->
                    items(count = cities.size) {
                        cities[it].id
                        ItemCity(
                            city = cities[it],
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}