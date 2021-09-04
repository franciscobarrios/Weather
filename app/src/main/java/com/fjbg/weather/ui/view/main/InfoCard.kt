package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.R
import com.fjbg.weather.ui.theme.categoryContentTextStyle
import com.fjbg.weather.ui.theme.categoryTitleTextStyle
import com.fjbg.weather.util.iconTint

@ExperimentalMaterialApi
@Composable
fun InfoCard(
    title: String,
    content: String,
    icon: Int,
    modifier: Modifier
) {
    Card(
        modifier = modifier.background(Color.Transparent),
        shape = RoundedCornerShape(24.dp),
        elevation = 4.dp,
        onClick = {}
    ) {
        Row(
            modifier = modifier.background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "info icon",
                    modifier = Modifier
                        .size(44.dp)
                        .padding(top = 4.dp, start = 10.dp, end = 4.dp),
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(iconTint(isSystemInDarkTheme()))
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = title,
                    style = categoryTitleTextStyle(isSystemInDarkTheme()),
                    maxLines = 1,
                    modifier = Modifier.padding(
                        top = 16.dp,
                        start = 8.dp,
                        end = 10.dp,
                        bottom = 2.dp
                    ),
                )
                Text(
                    text = content,
                    style = categoryContentTextStyle(isSystemInDarkTheme()),
                    maxLines = 1,
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 8.dp,
                        end = 10.dp,
                        bottom = 16.dp
                    ),
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun WindCardPreview() {
    InfoCard(
        title = "Wind",
        content = "15 Km/h",
        icon = R.drawable.ic_index_uv,
        modifier = Modifier.clickable(onClick = {})
    )
}
