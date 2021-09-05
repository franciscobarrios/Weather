package com.fjbg.weather.ui.view

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.getCountry
import com.fjbg.weather.util.textColor

@ExperimentalMaterialApi
@Composable
fun ItemAddCity(
    cityDto: CityDto,
    viewModel: WeatherViewModel? = null,
) {
    ItemCityCard(
        city = cityDto.name,
        country = cityDto.country,
        action = {
            viewModel?.saveCity(city = cityDto)
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun ItemCity(
    cityDto: CityDto,
    viewModel: WeatherViewModel? = null,
) {
    ItemCityCard(
        city = cityDto.name,
        country = cityDto.country
    )
}

@ExperimentalMaterialApi
@Composable
fun ItemCityCard(city: String, country: String, action: (() -> Unit)? = null) {
    Card(
        backgroundColor = Color(0xFFFFFFFF),//cityListBackgroundColor(isSystemInDarkTheme()),
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                alpha = 0.8f
            }
            .padding(
                bottom = 4.dp,
                top = 4.dp,
                end = 12.dp,
                start = 12.dp
            ),
        onClick = {
            action?.invoke()
        },
        shape = RoundedCornerShape(24.dp),
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
                .padding(18.dp)
                .background(Color.Transparent)
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ItemCityTextPreview() {
    ItemCityCard(
        city = "Villarrica",
        country = "CL",
    )
}
