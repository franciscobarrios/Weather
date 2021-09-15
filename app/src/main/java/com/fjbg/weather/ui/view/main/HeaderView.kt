package com.fjbg.weather.ui.view.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeaderView(
    city: String?,
    country: String?,
    date: String?,
    timeOfTheDay: TimeOfTheDay,
    actionAddLocation: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlaceName(
            city = city ?: "",
            country = country ?: "",
            date = date ?: "",
            timeOfTheDay = timeOfTheDay,
        )
        IconButton(
            onClick = {
                actionAddLocation.invoke()
            },
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add location",
                tint = dynamicTextColor(timeOfTheDay),
            )
        }
    }
}

@Preview
@Composable
fun HeaderViewPreview() {
    HeaderView(
        city = "Bangkok",
        country = "Thailand",
        date = "sat, 21 Aug 2021",
        timeOfTheDay = TimeOfTheDay.DAY,
        actionAddLocation = {},
    )
}