package com.fjbg.weather.animation

import android.content.res.Resources
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random
import kotlin.time.ExperimentalTime

@ExperimentalTime
@Composable
fun Raining() {

    val displayMetrics = Resources.getSystem().displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val screenWidth = displayMetrics.widthPixels

    val starList = mutableListOf<Star>()

    val initRandomAlpha = remember { mutableListOf(0f) }

    for (stars in 1..50) {

    }


    val infiniteTransition = rememberInfiniteTransition()

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        starList.forEach {
            drawCircle(
                color = Color.White,
                alpha = alpha,
                radius = it.radius,
                center = Offset(
                    it.positionX,
                    it.positionY
                )
            )
        }
    }
}

data class Rain(
    val positionX: Float,
    val positionY: Float,
    val radius: Float,
    val alpha: Float,
)

@ExperimentalTime
@Preview
@Composable
fun RainingPreview() {
    Raining()
}
