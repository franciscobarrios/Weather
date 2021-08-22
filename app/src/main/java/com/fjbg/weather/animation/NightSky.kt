package com.fjbg.weather.animation

import android.content.res.Resources
import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fjbg.weather.data.TAG
import java.lang.Math.random
import kotlin.time.ExperimentalTime

@ExperimentalTime
@Composable
fun NightSky() {

    val displayMetrics = Resources.getSystem().displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val screenWidth = displayMetrics.widthPixels


    for (star in 1 until 10 ) {
        val star1 = Star(
            positionX = star.toFloat(),
            positionY = star.toFloat()
        )

        Log.d(TAG, "NightSky: $star1")
    }


    val infiniteTransition = rememberInfiniteTransition()

    val positionX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 800f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5000, easing = LinearEasing
            )
        )
    )
    val positionY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 800f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5000, easing = LinearEasing
            )
        )
    )

    star(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
        x = positionX,
        y = positionY
    )

    /*for (x in 0 until 500 step 50) {
        for (y in 0 until 500 step 50) {
            star(
                modifier = Modifier.fillMaxSize(),
                color = color,
                x = Random.nextInt(0, x).toFloat(),
                y = y.toFloat()
            )
        }
    }*/


    val color by infiniteTransition.animateColor(
        initialValue = Color.White,
        targetValue = Color.Black,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5000, easing = LinearEasing
            )
        )
    )

}

data class Star(
    val positionX: Float,
    val positionY: Float,
    var color: Color? = Color.White
) {
    var xPos: Float = random().toFloat()
    var yPos: Float = random().toFloat()
}

@Composable
fun star(modifier: Modifier, color: Color, x: Float, y: Float) {
    Canvas(modifier = modifier) {
        drawCircle(
            color = color,
            radius = 10f,
            center = Offset(x, y)
        )
    }
}


@ExperimentalTime
@Preview
@Composable
fun NightSkyPreview() {
    NightSky()
}
