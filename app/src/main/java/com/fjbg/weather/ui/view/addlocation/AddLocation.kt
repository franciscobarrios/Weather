package com.fjbg.weather.ui.view.addlocation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.data.TAG
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.backgroundBrush
import com.fjbg.weather.util.getCountry
import com.fjbg.weather.util.oneDecimal
import java.util.*

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AddLocationView(
    viewModel: WeatherViewModel?,
    actionGoBack: () -> Unit
) {

    val cityWeatherList = viewModel?.cityWeatherList?.value
    Log.d(TAG, "AddLocationView: cityWeatherList= $cityWeatherList")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush(isSystemInDarkTheme()))
    ) {
        Column {
            SearchCity(viewModel)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(12.dp)
            ) {
                val list = viewModel?.getCityList()

                list?.let {
                    viewModel.updateCurrentCityWeather(it)
                }

                list?.run {
                    items(count = this.size) {
                        val cityDto = this@run[it]

                        Log.d(TAG, "AddLocationView: getCityList()= $cityDto")

                        CityCountryText(
                            cityDto = cityDto,
                            viewModel = viewModel
                        )
                    }
                }
            }
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {

                cityWeatherList?.let { cityWeather ->
                    items(count = cityWeatherList.size) {
                        CityWeatherWidget(
                            temperature = cityWeather[it].temperature.oneDecimal().toString(),
                            icon = cityWeather[it].icon,
                            city = cityWeather[it].city,
                            country = cityWeather[it].country,
                            humidity = cityWeather[it].humidity.oneDecimal().toString(),
                            wind = cityWeather[it].wind.oneDecimal().toString(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CityCountryText(
    cityDto: CityDto,
    viewModel: WeatherViewModel?
) {
    Box(modifier = Modifier.clickable {
        viewModel?.saveCity(city = cityDto)
    }) {
        Text(
            text = "${cityDto.name}, ${cityDto.country.getCountry()}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 18.dp,
                    end = 18.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
        )
    }
}

@Composable
fun SearchCity(viewModel: WeatherViewModel?) {
    val textState = remember { mutableStateOf("") }
    TextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,//textColor(isSystemInDarkTheme()),
            backgroundColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = "Search",
                style = TextStyle(
                    color = Color.Gray//textColor(isSystemInDarkTheme())
                ),
            )
        },
        leadingIcon = {
            if (textState.value.isEmpty())
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search cities"
                )
        },
        trailingIcon = {
            if (textState.value.isNotEmpty())
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear search",
                    modifier = Modifier.clickable(onClick = {
                        textState.value = ""
                    })
                )
        },
        value = textState.value,
        onValueChange = {
            textState.value = it
            if (it.isNotEmpty() && it.length > 2) {
                viewModel?.searchCityByName(it)
            }
        },
        singleLine = true,
        maxLines = 1,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 28.dp,
                bottom = 16.dp
            )
    )
}

@Preview
@Composable
fun SearchCityPreview() {
    SearchCity(viewModel = null)
}


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun AddLocationViewPreview() {
    /*WeatherTheme(darkTheme = false) {
        AddLocationView(
            viewModel = null,
            actionGoBack = {}
        )
    }*/
}