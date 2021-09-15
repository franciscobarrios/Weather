package com.fjbg.weather.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.fjbg.weather.ui.view.main.TimeOfTheDay
import com.fjbg.weather.ui.view.main.dynamicTextColor

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

fun titleTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 28.sp,
    color = dynamicTextColor(timeOfTheDay),
    textAlign = TextAlign.Start,
    fontWeight = FontWeight.Normal
)

fun cityTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    color = dynamicTextColor(timeOfTheDay),
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center
)

fun countryTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    color = dynamicTextColor(timeOfTheDay),
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center
)

fun dateTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = dynamicTextColor(timeOfTheDay),
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center
)

//endregion

//region Text Style Temp

fun currentTempTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 72.sp,
    color = dynamicTextColor(timeOfTheDay),
    fontWeight = FontWeight.ExtraBold,
    textAlign = TextAlign.Center
)

fun descriptionTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = dynamicTextColor(timeOfTheDay),
    textAlign = TextAlign.Center
)

fun categoryTitleTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    color = dynamicTextColor(timeOfTheDay),
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Normal,
)

fun categoryContentTextStyle(timeOfTheDay: TimeOfTheDay): TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    color = dynamicTextColor(timeOfTheDay),
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Normal,
)
//endregion