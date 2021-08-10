package com.fjbg.weather.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainView() {
    Box(
        Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .background(Color.White)
        ) {
            PlaceName()
        }
    }
}

@Composable
fun PlaceName() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Thailand,",
                fontSize = 12.sp,
                color = Color.Gray,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start

        ) {
            Text(
                text = "Bangkok",
                fontSize = 18.sp,
                color = Color.DarkGray,
            )
        }
    }
}

@Composable
fun WeatherImage() {

}

@Preview
@Composable
fun SimpleComposablePreview() {
    MainView()
}
