package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.R
import com.fjbg.weather.animation.NightSky
import com.fjbg.weather.ui.theme.currentTempTextStyle
import com.fjbg.weather.ui.theme.descriptionTextStyle

@Composable
fun WeatherInfo(
    temp: String,
    description: String,
    icon: Int?
) {
    Box(modifier = Modifier
        .fillMaxWidth()) {
        NightSky()
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon ?: R.drawable.dunno),
                contentDescription = "weather icon",
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(108.dp)
                    .fillMaxWidth(),
            )
            Text(
                text = temp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = currentTempTextStyle
            )
            Text(
                text = description,
                modifier = Modifier.fillMaxWidth(),
                style = descriptionTextStyle
            )
        }
    }


}

@Preview
@Composable
fun WeatherInfoPreview() {
    WeatherInfo(
        icon = R.drawable.tstorm3,
        temp = "31°",
        description = "Thunderstorm",
    )
}