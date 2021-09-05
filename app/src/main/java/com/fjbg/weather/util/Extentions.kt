package com.fjbg.weather.util

import android.icu.util.Calendar
import android.text.format.DateFormat
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import java.util.*
import kotlin.math.roundToInt

fun Long.toDate(): String {
    val calendar = Calendar.getInstance(Locale.getDefault())
    calendar.timeInMillis = this * 1000
    return DateFormat.format("E, dd MMM yyyy", calendar.timeInMillis).toString()
}

fun Float.oneDecimal(): Float = ((this * 10.0).roundToInt() / 10.0).toFloat()

fun background(isSystemInDarkTheme: Boolean): Color =
    if (isSystemInDarkTheme) Color.Black else Color.White

fun iconTint(isSystemInDarkTheme: Boolean): Color =
    if (isSystemInDarkTheme) Color(0xFFA2A2A2) else Color.Black

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

fun textColor(isSystemInDarkTheme: Boolean): Color {
    return if (isSystemInDarkTheme) Color.White else Color.Black
}