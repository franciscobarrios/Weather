package com.fjbg.weather.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fjbg.weather.R

@Composable
fun InfoCardSection(
    humidity: String,
    indexUv: String,
    wind: String,
    aqi: String,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (card1, card2, card3, card4) = createRefs()
        InfoCard(
            title = "Humidity",
            content = "$humidity%",
            icon = R.drawable.ic_wind,
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
            content = indexUv,
            icon = R.drawable.ic_index_uv,
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
            icon = R.drawable.ic_index_uv,
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
            content = aqi,
            icon = R.drawable.ic_index_uv,
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

@Preview
@Composable
fun InfoCardSectionPreview() {
    InfoCardSection(
        humidity = "98%",
        indexUv = "12",
        wind = "23",
        aqi = "46",
    )
}