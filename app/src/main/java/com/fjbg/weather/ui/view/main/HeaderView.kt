package com.fjbg.weather.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeaderView(
    city: String?,
    country: String?,
    date: String?,
    actionAddLocation: () -> Unit,
    actionLocationList: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            actionLocationList.invoke()
        }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = Color.Black,
            )
        }
        PlaceName(
            city = city ?: "Bangkok",
            country = country ?: "Thailand",
            date = date ?: "sat, 21 Aug 2021",
        )
        IconButton(
            onClick = {
                actionAddLocation.invoke()
            },
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add location",
                tint = Color.Black,
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
        actionAddLocation = {},
        actionLocationList = {}
    )
}