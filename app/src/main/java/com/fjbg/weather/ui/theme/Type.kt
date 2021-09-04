package com.fjbg.weather.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.fjbg.weather.util.textColor

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

//region Text Style Location

fun titleTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 28.sp,
    color = textColor(isSystemInDarkTheme),
    textAlign = TextAlign.Start,
    fontWeight = FontWeight.Normal
)

fun cityTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    color = textColor(isSystemInDarkTheme),
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center
)

fun countryTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    color = textColor(isSystemInDarkTheme),
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center
)

fun dateTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = textColor(isSystemInDarkTheme),
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center
)

//endregion

//region Text Style Temp

fun currentTempTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 72.sp,
    color = textColor(isSystemInDarkTheme),
    fontWeight = FontWeight.ExtraBold,
    textAlign = TextAlign.Center
)

fun descriptionTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = textColor(isSystemInDarkTheme),
    textAlign = TextAlign.Center
)

fun categoryTitleTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    color = textColor(isSystemInDarkTheme),
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Normal,
)

fun categoryContentTextStyle(isSystemInDarkTheme: Boolean): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    color = textColor(isSystemInDarkTheme),
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Normal,
)
//endregion