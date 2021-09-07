package com.fjbg.weather.ui.view.addlocation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.weather.data.TAG
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.cityListBackgroundColor
import com.fjbg.weather.util.getCountry
import com.fjbg.weather.util.textColor

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ItemAddCity(
    cityDto: CityDto,
    viewModel: WeatherViewModel,
) {
    ItemCityCard(
        city = cityDto.name,
        country = cityDto.country,
        action = {
            viewModel.saveCity(city = cityDto)
        }
    )
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ItemCity(
    city: CityDto,
    viewModel: WeatherViewModel,
) {
    ItemCityCard(
        city = city.name,
        country = city.country,
        action = {
            Log.d(TAG, "ItemCity: city: $city")
            viewModel.deleteCity(city = city)
        }
    )
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ItemCityCard(
    city: String,
    country: String,
    action: (() -> Unit)? = null
) {
    Card(
        backgroundColor = cityListBackgroundColor(isSystemInDarkTheme()),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 4.dp,
                top = 4.dp,
                end = 12.dp,
                start = 12.dp
            )
            .combinedClickable(
                onLongClick = {
                    Log.d(TAG, "ItemCityCard: onLongClick")
                }
            ) {},
        shape = RoundedCornerShape(28.dp),
        elevation = 8.dp,
    ) {
        Text(
            text = "$city, ${country.getCountry()}",
            style = TextStyle(
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal
            ),
            color = textColor(isSystemInDarkTheme()),
            modifier = Modifier
                .background(Color.Transparent)
                .padding(18.dp)
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun ItemCityTextPreview() {
    ItemCityCard(
        city = "Villarrica",
        country = "CL",
    )
}
