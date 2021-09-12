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

fun Double.oneDecimal(): Double = ((this * 10).roundToInt() / 10).toDouble()

fun String.getCountry(): String = Locale("en", this).displayCountry

fun background(isSystemInDarkTheme: Boolean): Color =
    if (isSystemInDarkTheme) Color.Black else Color.White

fun iconTint(isSystemInDarkTheme: Boolean): Color =
    if (isSystemInDarkTheme) Color(0xFFA2A2A2) else Color.Black

fun textColor(isSystemInDarkTheme: Boolean): Color {
    return if (isSystemInDarkTheme) Color.White else Color(0xFF292929)
}

fun cityListBackgroundColor(isSystemInDarkTheme: Boolean): Color {
    return if (isSystemInDarkTheme) Color(0xFF000000) else Color(0x99EBEBEB)
}