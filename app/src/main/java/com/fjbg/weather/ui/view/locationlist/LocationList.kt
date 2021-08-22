package com.fjbg.weather.ui.view.locationlist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LocationListView(
    actionGoBack:()->Unit
){
    Text(text = "Location list")
}

@Preview
@Composable
fun LocationListPreview(){
    LocationListView(
        actionGoBack={}
    )
}