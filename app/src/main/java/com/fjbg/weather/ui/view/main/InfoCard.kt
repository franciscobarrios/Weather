package com.fjbg.weather.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.R
import com.fjbg.weather.ui.theme.categoryContentTextStyle
import com.fjbg.weather.ui.theme.categoryTitleTextStyle

@Composable
fun InfoCard(
    title: String,
    content: String,
    icon: Int,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        elevation = 4.dp,
    ) {
        Row(
            modifier = modifier
                .background(Color.White)
                .clickable(onClick = {}),
        ) {
            Column {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "info icon",
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Inside
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = title,
                    style = categoryTitleTextStyle,
                    maxLines = 1,
                    modifier = Modifier.padding(
                        top = 16.dp,
                        start = 2.dp,
                        end = 12.dp,
                        bottom = 2.dp
                    ),
                )
                Text(
                    text = content,
                    style = categoryContentTextStyle,
                    maxLines = 1,
                    modifier = Modifier.padding(
                        top = 2.dp,
                        start = 2.dp,
                        end = 12.dp,
                        bottom = 16.dp
                    ),
                )
            }
        }
    }
}


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
