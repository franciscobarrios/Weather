package com.fjbg.weather.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherInfo(
    temp: String,
    description: String,
    humidity: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = temp,
            fontSize = 72.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Text(
            text = description,
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Text(
            text = humidity,
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun WeatherInfoPreview() {
    WeatherInfo(
        temp = "31",
        description = "Sunny",
        humidity = "98%"
    )
}