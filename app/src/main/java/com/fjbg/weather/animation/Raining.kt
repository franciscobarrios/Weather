package com.fjbg.weather.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun Raining(position: ObjectPosition) {

    val infiniteTransition = rememberInfiniteTransition()

    val color = if (position.z > 1) Color(0x88FFFFFF) else Color(0x2A3C3C3C)
    val length = if (position.z > 2) 0.015f else 0.01f
    val duration = Random.nextInt(1000, 2500)

    val positionY by infiniteTransition.animateFloat(
        initialValue = position.y * -1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            keyframes {
                durationMillis = duration
            }, repeatMode = RepeatMode.Restart
        )
    )

    Canvas(
        modifier = Modifier
            //.fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(0.5f)

    ) {

        drawLine(
            strokeWidth = 5f,
            color = color,
            start = Offset(
                x = size.width * position.x,
                y = size.height * positionY,
            ),
            end = Offset(
                x = size.width * position.x,
                y = size.height * positionY + size.height * length
            )
        )
    }
}