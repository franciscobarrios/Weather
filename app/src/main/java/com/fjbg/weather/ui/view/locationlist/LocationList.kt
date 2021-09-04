package com.fjbg.weather.ui.view.locationlist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fjbg.weather.ui.viewmodel.WeatherViewModel

@Composable
fun LocationListView(
    viewModel: WeatherViewModel?,
    actionGoBack: () -> Unit
) {
    Text(text = "Location list")
}

@Preview
@Composable
fun LocationListPreview() {
    LocationListView(
        viewModel = null,
        actionGoBack = {}
    )
}