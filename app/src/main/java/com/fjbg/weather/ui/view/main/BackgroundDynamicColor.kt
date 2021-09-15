package com.fjbg.weather.ui.view.main

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter

fun dynamicTextColor(timeOfTheDay: TimeOfTheDay): Color = when (timeOfTheDay) {
    TimeOfTheDay.DAWN -> Color(0xFF1B1B1B)
    TimeOfTheDay.DAY -> Color(0xFF272727)
    TimeOfTheDay.DUSK -> Color(0xFFD5D5D5)
    TimeOfTheDay.NIGHT -> Color(0xFFE4E4E4)
}


fun dynamicBackground(timeOfTheDay: TimeOfTheDay): Brush = when (timeOfTheDay) {
    TimeOfTheDay.DAWN -> Brush.verticalGradient(
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

    TimeOfTheDay.DAY -> Brush.verticalGradient(
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

    TimeOfTheDay.DUSK -> Brush.verticalGradient(
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

    TimeOfTheDay.NIGHT -> Brush.verticalGradient(
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

fun dynamicBackgroundWidget(timeOfTheDay: TimeOfTheDay): Brush = when (timeOfTheDay) {
    TimeOfTheDay.DAWN -> Brush.verticalGradient(
        colors = listOf(
            Color(0xFF74C5FF),
            Color(0xFFD4EDFF),
            Color(0xFFE6F4FF),
            Color(0xFFFFE096),
            Color(0xFFFF7E39),
        )
    )

    TimeOfTheDay.DAY -> Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFFFFF),
            Color(0xFFD4EDFF),
            Color(0xFFFAF0D8),
            Color(0xFFFFFFFF),
            Color(0xFFDADADA),
        )
    )
    TimeOfTheDay.DUSK -> Brush.verticalGradient(
        colors = listOf(
            Color(0xFF24263B),
            Color(0xFF413D60),
            Color(0xFF7E5E79),
            Color(0xFFDE8A64),
            Color(0xFF6D2F24),
        )
    )
    TimeOfTheDay.NIGHT -> Brush.verticalGradient(
        colors = listOf(
            Color(0xFF000000),
            Color(0xFF2D0041),
            Color(0xFF00104E),
            Color(0xFF04001D),
            Color(0xFF000000),
        )
    )
}


fun dynamicIconTint(timeOfTheDay: TimeOfTheDay): ColorFilter = when (timeOfTheDay) {
    TimeOfTheDay.DAWN -> ColorFilter.tint(Color(0xFF1B1B1B))
    TimeOfTheDay.DAY -> ColorFilter.tint(Color(0xFF272727))
    TimeOfTheDay.DUSK -> ColorFilter.tint(Color(0xFFD5D5D5))
    TimeOfTheDay.NIGHT -> ColorFilter.tint(Color(0xFFE4E4E4))
}

fun dynamicFabColor(timeOfTheDay: TimeOfTheDay): Color = when (timeOfTheDay) {
    TimeOfTheDay.DAWN -> Color(0xFF304FFE)
    TimeOfTheDay.DAY -> Color(0xFFFF6D00)
    TimeOfTheDay.DUSK -> Color(0xFFFFF59D)
    TimeOfTheDay.NIGHT -> Color(0xFFD1C4E9)
}

fun dynamicFabContentColor(timeOfTheDay: TimeOfTheDay): Color = when (timeOfTheDay) {
    TimeOfTheDay.DAWN -> Color(0xFFFFFFFF)
    TimeOfTheDay.DAY -> Color(0xFFFFFFFF)
    TimeOfTheDay.DUSK -> Color(0xFF000000)
    TimeOfTheDay.NIGHT -> Color(0xFF000000)
}

enum class TimeOfTheDay {
    DAWN, DAY, DUSK, NIGHT
}
