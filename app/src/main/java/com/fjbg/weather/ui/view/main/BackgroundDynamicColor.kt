package com.fjbg.weather.ui.view.main

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun backgroundBrush(isSystemInDarkTheme: Boolean): Brush =
    if (isSystemInDarkTheme) {
        Brush.verticalGradient(
            colors = listOf(
                Color.Black,
                Color.Black,
                Color(0xFF2D0041),
                Color(0xFF00104E),
                Color(0xFF04001D),
                Color.Black,
                Color.Black,
                Color.Black,
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color.White,
                Color(0xFFD4EDFF),
                Color(0xFFFAF0D8),
                Color(0xFFFAF0D8),
                Color.White,
                Color.White,
                Color(0xFFDADADA),
                Color(0xFFDADADA),
                Color(0xFFDADADA),
            )
        )
    }

enum class TimeOfTheDay {
    DAWN, DAY, DUSK, NIGHT
}

fun dynamicBackground(timeOfTheDay: TimeOfTheDay): Brush {
    return when (timeOfTheDay) {
        TimeOfTheDay.DAWN -> {
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF74C5FF),
                    Color(0xFF74C5FF),
                    Color(0xFFAADAFC),
                    Color(0xFFD4EDFF),
                    Color(0xFFD4EDFF),
                    Color(0xFFFAF0D8),
                    Color(0xFFFAF0D8),
                    Color(0xFFFFE096),
                    Color(0xFFFF7E39),
                )
            )
        }
        TimeOfTheDay.DAY -> {
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFFFFF),
                    Color(0xFFD4EDFF),
                    Color(0xFFFAF0D8),
                    Color(0xFFFAF0D8),
                    Color(0xFFFFFFFF),
                    Color(0xFFFFFFFF),
                    Color(0xFFDADADA),
                    Color(0xFFDADADA),
                    Color(0xFFDADADA),
                )
            )
        }
        TimeOfTheDay.DUSK -> {
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF071A22),
                    Color(0xFF24263B),
                    Color(0xFF272A41),
                    Color(0xFF413D60),
                    Color(0xFF7E5E79),
                    Color(0xFFDE8A64),
                    Color(0xFF6D2F24),
                    Color(0xFF0C0B0E),
                )
            )
        }
        TimeOfTheDay.NIGHT -> {
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF000000),
                    Color(0xFF000000),
                    Color(0xFF2D0041),
                    Color(0xFF00104E),
                    Color(0xFF04001D),
                    Color(0xFF000000),
                    Color(0xFF000000),
                    Color(0xFF000000),
                )
            )
        }
    }
}


