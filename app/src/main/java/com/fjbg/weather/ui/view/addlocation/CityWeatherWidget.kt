package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.weather.R
import com.fjbg.weather.data.CELSIUS
import com.fjbg.weather.data.HUMIDITY
import com.fjbg.weather.data.WIND_SPEED_MS
import com.fjbg.weather.ui.view.main.TimeOfTheDay
import com.fjbg.weather.ui.view.main.dynamicBackgroundWidget
import com.fjbg.weather.ui.view.main.dynamicIconTint
import com.fjbg.weather.ui.view.main.dynamicTextColor
import com.fjbg.weather.util.getCountry
import com.fjbg.weather.util.iconTint

@ExperimentalMaterialApi
@Composable
fun CityWeatherWidget(
    temperature: String,
    city: String,
    country: String,
    humidity: String,
    wind: String,
    timeOfTheDay: TimeOfTheDay,
) {
    Card(
        onClick = {},
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(dynamicBackgroundWidget(timeOfTheDay)),
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$temperature$CELSIUS",
                    style = TextStyle(
                        color = dynamicTextColor(timeOfTheDay),
                        fontSize = 56.sp,
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier.padding(8.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_humidity),
                        contentDescription = "weather icon",
                        alignment = Alignment.Center,
                        colorFilter = dynamicIconTint(timeOfTheDay),
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                bottom = 8.dp,
                                top = 2.dp,
                                end = 2.dp
                            )
                            .size(22.dp)
                    )

                    Text(
                        text = "$humidity$HUMIDITY",
                        style = TextStyle(
                            color = dynamicTextColor(timeOfTheDay),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(
                            start = 2.dp,
                            bottom = 12.dp,
                            top = 2.dp,
                            end = 6.dp
                        )
                    )

                    Spacer(modifier = Modifier.padding(2.dp))

                    Image(
                        painter = painterResource(R.drawable.ic_wind),
                        contentDescription = "weather icon",
                        alignment = Alignment.Center,
                        colorFilter = dynamicIconTint(timeOfTheDay),
                        modifier = Modifier
                            .padding(
                                start = 12.dp,
                                bottom = 8.dp,
                                top = 2.dp,
                                end = 2.dp
                            )
                            .size(22.dp)
                    )

                    Text(
                        text = "$wind$WIND_SPEED_MS",
                        style = TextStyle(
                            color = dynamicTextColor(timeOfTheDay),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(
                            start = 2.dp,
                            bottom = 12.dp,
                            top = 2.dp,
                            end = 8.dp
                        )
                    )
                }
            }

            Column {
                Text(
                    text = city,
                    style = TextStyle(
                        color = dynamicTextColor(timeOfTheDay),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .requiredWidth(160.dp)
                        .padding(
                            start = 12.dp,
                            bottom = 1.dp,
                            top = 8.dp,
                            end = 12.dp
                        )
                )
                Text(
                    text = country.getCountry(),
                    style = TextStyle(
                        color = dynamicTextColor(timeOfTheDay),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .requiredWidth(120.dp)
                        .padding(
                            start = 12.dp,
                            bottom = 8.dp,
                            top = 1.dp,
                            end = 12.dp
                        )
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CityWeatherWidgetPreview() {
    CityWeatherWidget(
        temperature = "-7",
        city = "Tierra del Fuego",
        country = "Chile",
        humidity = "12.0",
        wind = "12.0",
        timeOfTheDay = TimeOfTheDay.DAY,
    )
}