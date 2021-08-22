package com.fjbg.weather.animation

import android.content.res.Resources
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

    for (stars in 1..50) {
        val star = Star(
            positionX = Random.nextInt(0, screenWidth).toFloat(),
            positionY = Random.nextInt(0, (screenHeight / 2)).toFloat(),
            radius = Random.nextInt(2, 6).toFloat()
        )
        starList.add(star)
    }

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.White,
        targetValue = Color.Black,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5000, easing = LinearEasing
            )
        )
    )

    Canvas(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        starList.forEach {
            drawCircle(
                color = color,
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
)

@ExperimentalTime
@Preview
@Composable
fun RainingPreview() {
    Raining()
}
