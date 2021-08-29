package com.fjbg.weather.animation

import android.util.Log
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fjbg.weather.data.TAG

const val animationDuration: Int = 2000

enum class ButtonState {
    Pressed, Released
}

@Composable
fun CircularReveal() {

    val toState by remember { mutableStateOf(ButtonState.Released) }
    val transition: Transition<ButtonState> = updateTransition(targetState = toState, label = "")

    var isPressed by remember { mutableStateOf(false) }

    val scale: Float by transition.animateFloat(
        label = "", transitionSpec = {
            keyframes {
                58f at 0
                30f at 500
                3000f at animationDuration
            }
        }
    ) { state ->
        when (state) {
            ButtonState.Pressed -> if (isPressed) 0f else 100f
            ButtonState.Released -> if (isPressed) 3000f else 100f
        }
    }

    val alpha: Float by transition.animateFloat(
        label = "", transitionSpec = {
            keyframes {
                1f at 0
                0.5f at animationDuration
            }
        }
    ) { state ->
        when (state) {
            ButtonState.Pressed -> if (isPressed) 0.5f else 1f
            ButtonState.Released -> if (isPressed) 0.5f else 1f
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .drawBehind {
                drawCircle(
                    color = Color.Black,
                    radius = scale,
                    center = Offset(
                        x = size.width,
                        y = 0f
                    ),
                    alpha = alpha
                )
            }
    ) {

        Button(onClick = {
            isPressed = !isPressed
        }) {
            Log.d(TAG, "CircularReveal: isPressed = $isPressed")
        }
    }
}

@Preview
@Composable
fun CircularRevealPreview(
) {
    CircularReveal()
}