package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import com.fjbg.weather.ui.theme.descriptionTextStyle
import com.fjbg.weather.util.TimeOfTheDay

@Composable
fun WeatherInfo(
    temperature: String?,
    description: String?,
    icon: Int?,
    timeOfTheDay: TimeOfTheDay
) {

    val currentTemp = temperature ?: ""

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

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
                text = "$currentTemp°c",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = descriptionTextStyle(timeOfTheDay)
            )
            Text(
                text = description ?: "",
                modifier = Modifier.fillMaxWidth(),
                style = descriptionTextStyle(timeOfTheDay)
            )
        }
    }


}

@Preview
@Composable
fun WeatherInfoPreview() {
    WeatherInfo(
        icon = R.drawable.tstorm3,
        temperature = "31°",
        description = "Thunderstorm",
        timeOfTheDay = TimeOfTheDay.DAY
    )
}