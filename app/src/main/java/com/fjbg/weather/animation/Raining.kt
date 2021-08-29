package com.fjbg.weather.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun RainingForecast(intensity: Int, isNight: Boolean) {
    val objectList = generatePosition(intensity)

    objectList.forEach {
        Raining(objectPosition = it, isNight)
    }
}

@Composable
fun Raining(objectPosition: ObjectPosition, isNight: Boolean) {

    val infiniteTransition = rememberInfiniteTransition()

    val color = when (objectPosition.z) {
        in 1..5 -> if (isNight) Color(0x8DE0E0E0) else Color(0x9ED1D1D1)
        in 6..10 -> if (isNight) Color(0xA8949494) else Color(0xA87E7E7E)
        else -> Color(0x48363636)
    }

    val length = when (objectPosition.z) {
        in 1..3 -> 0.2f
        in 3..6 -> 0.15f
        in 6..10 -> 0.05f
        else -> 0.01f
    }

    val duration = Random.nextInt(600, 2500)

    val positionY by infiniteTransition.animateFloat(
        initialValue = objectPosition.y * -1f,
        targetValue = 2.5f,
        animationSpec = infiniteRepeatable(
            keyframes {
                durationMillis = duration
            }, repeatMode = RepeatMode.Restart
        )
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        drawLine(
            strokeWidth = 5f,
            color = color,
            start = Offset(
                x = size.width * objectPosition.x,
                y = size.height * positionY,
            ),
            end = Offset(
                x = size.width * objectPosition.x,
                y = size.height * positionY + size.height * length
            )
        )
    }
}