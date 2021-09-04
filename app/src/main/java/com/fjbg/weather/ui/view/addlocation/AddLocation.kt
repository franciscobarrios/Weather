package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.ui.theme.WeatherTheme
import com.fjbg.weather.ui.theme.titleTextStyle
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.backgroundBrush
import com.fjbg.weather.util.textColor

@Composable
fun AddLocationView(
    viewModel: WeatherViewModel?,
    actionGoBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush(isSystemInDarkTheme()))
    ) {
        Column {
            val textState = remember { mutableStateOf(TextFieldValue()) }

            Text(
                text = "Add a new city",
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

            TextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                    if (it.text.isNotEmpty() && it.text.length > 2) {
                        viewModel?.searchCityByName(it.text)
                    }
                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        top = 4.dp,
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
                val list = viewModel?.getCityList()
                list?.let { cities ->
                    items(count = cities.size) {
                        cities[it].id
                        ItemCity(
                            cities[it],
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ItemCity(
    cityDto: CityDto,
    viewModel: WeatherViewModel?,
) {
    Box(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxWidth()
        .clickable {
            viewModel?.saveCity(city = cityDto)
        }
    ) {
        Text(
            text = "${cityDto.name}, ${cityDto.country}",
            style = TextStyle(
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Light
            ),
            color = textColor(isSystemInDarkTheme()),
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AddLocationViewPreview() {
    WeatherTheme(darkTheme = false) {
        AddLocationView(
            viewModel = null,
            actionGoBack = {}
        )
    }
}