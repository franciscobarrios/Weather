package com.fjbg.weather.data.mapper

import com.fjbg.weather.R

fun iconMapper(iconId: Int): String? {
    when (iconId) {

    }
    return null
}

enum class IconWeather(resource: Int) {
    THUNDERSTORM_WITH_LIGHT_RAIN(R.drawable.ic_celcius),
    THUNDERSTORM_WITH_RAIN(R.drawable.ic_celcius);
}