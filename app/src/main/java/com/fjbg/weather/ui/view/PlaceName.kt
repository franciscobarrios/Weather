package com.fjbg.weather.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlaceName(
    city: String,
    country: String,
    date: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$city, $country",
                fontSize = 16.sp,
                color = Color.DarkGray,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "$date",
                fontSize = 14.sp,
                color = Color.Gray,
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
        date = "Sun 15 Aug"
    )
}