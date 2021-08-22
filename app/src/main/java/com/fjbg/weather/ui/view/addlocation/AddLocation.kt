package com.fjbg.weather.ui.view.addlocation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddLocationView(actionGoBack: () -> Unit) {
    Text(text = "Add location")
}

@Preview
@Composable
fun AddLocationViewPreview() {
    AddLocationView(
        actionGoBack = {}
    )
}