package com.fjbg.weather.animation

import android.content.res.Resources
import androidx.compose.animation.core.*
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

@Composable
fun NightSky() {

    val displayMetrics = Resources.getSystem().displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val screenWidth = displayMetrics.widthPixels

    val staticStarList = mutableListOf<Star>()
    val alphaStarList = mutableListOf<Star>()

    for (staticStars in 1..100) {
        val star = Star(
            positionX = Random.nextInt(0, screenWidth).toFloat(),
            positionY = Random.nextInt(0, (screenHeight / 2)).toFloat(),
            radius = Random.nextInt(1, 5).toFloat(),
            alpha = 0.2f + (Random.nextFloat() * (0.8f - 0.2f))
        )
        staticStarList.add(star)
    }

    for (alphaStars in 1..50) {
        val star = Star(
            positionX = Random.nextInt(0, screenWidth).toFloat(),
            positionY = Random.nextInt(0, (screenHeight / 2)).toFloat(),
            radius = Random.nextInt(1, 4).toFloat(),
        )
        alphaStarList.add(star)
    }

    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ) {
        alphaStarList.forEach { a ->
            drawCircle(
                color = Color.White,
                radius = a.radius,
                center = Offset(
                    a.positionX,
                    a.positionY
                ),
                alpha = alpha
            )
        }
        staticStarList.forEach { s ->
            drawCircle(
                color = Color.White,
                radius = s.radius,
                center = Offset(
                    s.positionX,
                    s.positionY
                ),
                alpha = s.alpha ?: 1f
            )
        }
    }
}

data class Star(
    val positionX: Float,
    val positionY: Float,
    val radius: Float,
    val alpha: Float? = 1f,
)

@ExperimentalTime
@Preview
@Composable
fun NightSkyPreview() {
    NightSky()
}
