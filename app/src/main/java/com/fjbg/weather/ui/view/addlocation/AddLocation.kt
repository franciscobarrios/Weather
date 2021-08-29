package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fjbg.weather.util.backgroundBrush

@Composable
fun AddLocationView(actionGoBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush(isSystemInDarkTheme()))
    ) {
        Text(text = "Add location")
    }
}

@Preview
@Composable
fun AddLocationViewPreview() {
    AddLocationView(
        actionGoBack = {}
    )
}