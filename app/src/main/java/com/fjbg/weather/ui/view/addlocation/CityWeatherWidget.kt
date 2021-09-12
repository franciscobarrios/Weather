package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.Image
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
import com.fjbg.weather.data.mapper.iconIdToIconWeather
import com.fjbg.weather.data.mapper.owApiIconToIntResourceDay
import com.fjbg.weather.util.iconTint
import com.fjbg.weather.util.textColor
import java.util.*

@ExperimentalMaterialApi
@Composable
fun CityWeatherWidget(
    temperature: String,
    icon: Int,
    city: String,
    country: String,
    humidity: String,
    wind: String
) {
    Card(
        onClick = {},
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "$temperature°c",
                    style = TextStyle(
                        color = textColor(isSystemInDarkTheme()),
                        fontSize = 32.sp
                    ),
                    modifier = Modifier.padding(12.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))

                val iconWeather = iconIdToIconWeather(icon)
                val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

                iconWeather?.let {
                    val id = owApiIconToIntResourceDay(it, currentTime > 18)
                    Image(
                        painter = painterResource(id),
                        contentDescription = "weather icon",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .size(52.dp),
                    )
                }
            }
            Column {
                Text(
                    text = city,
                    style = TextStyle(
                        color = textColor(isSystemInDarkTheme()),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        bottom = 1.dp,
                        top = 8.dp,
                        end = 12.dp
                    )
                )
                Text(
                    text = country,
                    style = TextStyle(
                        color = textColor(isSystemInDarkTheme()),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        bottom = 8.dp,
                        top = 1.dp,
                        end = 12.dp
                    )
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_humidity),
                    contentDescription = "weather icon",
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(iconTint(isSystemInDarkTheme())),
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
                    text = "$humidity%",
                    style = TextStyle(
                        color = textColor(isSystemInDarkTheme()),
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
                    colorFilter = ColorFilter.tint(iconTint(isSystemInDarkTheme())),
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
                    text = "$wind m/s",
                    style = TextStyle(
                        color = textColor(isSystemInDarkTheme()),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.padding(
                        start = 2.dp,
                        bottom = 12.dp,
                        top = 2.dp,
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
        temperature = "28",
        icon = R.drawable.shower2_night,
        city = "Bangkok",
        country = "Thailand",
        humidity = "12",
        wind = "7",
    )
}