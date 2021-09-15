package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fjbg.weather.R

@ExperimentalMaterialApi
@Composable
fun InfoCardSection(
    humidity: String?,
    indexUv: String?,
    wind: String?,
    aqi: String?,
    timeOfTheDay: TimeOfTheDay,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (card1, card2, card3, card4) = createRefs()
        InfoCard(
            title = "Humidity",
            content = "$humidity%",
            icon = R.drawable.ic_humidity,
            timeOfTheDay = timeOfTheDay,
            modifier = Modifier
                .constrainAs(card1) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                }
                .padding(4.dp)
                .requiredWidth(158.dp)
        )

        InfoCard(
            title = "Index UV",
            content = indexUv.toString(),
            icon = R.drawable.ic_index_uv,
            timeOfTheDay = timeOfTheDay,
            modifier = Modifier
                .constrainAs(card2) {
                    top.linkTo(parent.top, margin = 16.dp)
                    end.linkTo(parent.end, margin = 12.dp)
                }
                .padding(4.dp)
                .requiredWidth(158.dp)
        )

        InfoCard(
            title = "Wind",
            content = "$wind m/s",
            icon = R.drawable.ic_wind,
            timeOfTheDay = timeOfTheDay,
            modifier = Modifier
                .constrainAs(card3) {
                    top.linkTo(card1.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
                .padding(4.dp)
                .requiredWidth(158.dp)
        )

        InfoCard(
            title = "AQI",
            content = aqi.toString(),
            icon = R.drawable.ic_aqi,
            timeOfTheDay = timeOfTheDay,
            modifier = Modifier
                .constrainAs(card4) {
                    top.linkTo(card2.bottom, margin = 16.dp)
                    end.linkTo(parent.end, margin = 12.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
                .padding(4.dp)
                .requiredWidth(158.dp)
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun InfoCardSectionPreview() {
    InfoCardSection(
        humidity = "98",
        indexUv = "21",
        wind = "5.7",
        aqi = "23",
        timeOfTheDay = TimeOfTheDay.DAY,
    )
}