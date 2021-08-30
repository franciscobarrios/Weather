package com.fjbg.weather.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

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
val cityTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    color = Color.DarkGray,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center
)

val countryTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    color = Color.DarkGray,
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center
)
val dateTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = Color.Gray,
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center
)
//endregion

//region Text Style Temp
val currentTempTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 72.sp,
    color = Color.DarkGray,
    fontWeight = FontWeight.ExtraBold,
    textAlign = TextAlign.Center
)

val descriptionTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = Color.DarkGray,
    textAlign = TextAlign.Center
)

val humidityTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = Color.DarkGray,
    textAlign = TextAlign.Center
)

val categoryTitleTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    color = Color.Gray,
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Normal,
)
val categoryContentTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    color = Color.DarkGray,
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Bold
)

val titleTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 28.sp,
    color = Color.DarkGray,
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.SemiBold
)


//endregion