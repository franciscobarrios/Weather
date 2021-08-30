package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.ui.theme.WeatherTheme
import com.fjbg.weather.ui.theme.titleTextStyle
import com.fjbg.weather.util.backgroundBrush

@Composable
fun AddLocationView(actionGoBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush(isSystemInDarkTheme()))
    ) {
        Column {
            Text(
                text = "Add a new location",
                style = titleTextStyle,
                modifier = Modifier.padding(
                    start = 32.dp,
                    end = 32.dp,
                    top = 32.dp,
                    bottom = 16.dp
                )
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.background(Color.Transparent).padding(
                    start = 32.dp,
                    end = 32.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
            )
        }
    }
}

@Preview
@Composable
fun AddLocationViewPreview() {
    WeatherTheme(darkTheme = false) {
        AddLocationView(
            actionGoBack = {}
        )
    }
}