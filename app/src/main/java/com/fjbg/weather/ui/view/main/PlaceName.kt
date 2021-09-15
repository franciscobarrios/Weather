package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.theme.cityTextStyle
import com.fjbg.weather.ui.theme.countryTextStyle
import com.fjbg.weather.ui.theme.dateTextStyle

@Composable
fun PlaceName(
    city: String,
    country: String,
    date: String,
    timeOfTheDay: TimeOfTheDay
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Text(
                    text = "$city, ",
                    style = cityTextStyle(timeOfTheDay),
                )
            }
            Column {
                Text(
                    text = country,
                    style = countryTextStyle(timeOfTheDay),
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = date,
                style = dateTextStyle(timeOfTheDay),
            )
        }
    }
}

@Preview
@Composable
fun PlaceNamePreview() {
    PlaceName(
        city = "Bangkok",
        country = "Thailand",
        date = "Sun 15 Aug",
        timeOfTheDay = TimeOfTheDay.DAY
    )
}