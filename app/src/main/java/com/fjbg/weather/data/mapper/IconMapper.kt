package com.fjbg.weather.data.mapper

import com.fjbg.weather.R

fun iconIdToIconWeather(iconId: Int): IconWeather? {
    return when (iconId) {
        200 -> IconWeather.THUNDERSTORM_WITH_LIGHT_RAIN
        201 -> IconWeather.THUNDERSTORM_WITH_RAIN
        202 -> IconWeather.THUNDERSTORM_WITH_HEAVY_RAIN
        210 -> IconWeather.LIGHT_THUNDERSTORM
        211 -> IconWeather.THUNDERSTORM
        212 -> IconWeather.HEAVY_THUNDERSTORM
        221 -> IconWeather.RAGGED_THUNDERSTORM
        230 -> IconWeather.THUNDERSTORM_WITH_LIGHT_DRIZZLE
        231 -> IconWeather.THUNDERSTORM_WITH_DRIZZLE
        232 -> IconWeather.THUNDERSTORM_WITH_HEAVY_DRIZZLE
        300 -> IconWeather.LIGHT_INTENSITY_DRIZZLE
        301 -> IconWeather.DRIZZLE
        302 -> IconWeather.HEAVY_INTENSITY_DRIZZLE
        310 -> IconWeather.LIGHT_INTENSITY_DRIZZLE_RAIN
        311 -> IconWeather.DRIZZLE_RAIN
        312 -> IconWeather.HEAVY_INTENSITY_DRIZZLE_RAIN
        313 -> IconWeather.SHOWER_RAIN_AND_DRIZZLE
        314 -> IconWeather.HEAVY_SHOWER_RAIN_AND_DRIZZLE
        321 -> IconWeather.SHOWER_DRIZZLE
        500 -> IconWeather.LIGHT_RAIN
        501 -> IconWeather.MODERATE_RAIN
        502 -> IconWeather.HEAVY_INTENSITY_RAIN
        503 -> IconWeather.VERY_HEAVY_RAIN
        504 -> IconWeather.EXTREME_RAIN
        511 -> IconWeather.FREEZING_RAIN
        520 -> IconWeather.LIGHT_INTENSITY_SHOWER_RAIN
        521 -> IconWeather.SHOWER_RAIN
        522 -> IconWeather.HEAVY_INTENSITY_SHOWER_RAIN
        531 -> IconWeather.RAGGED_SHOWER_RAIN
        600 -> IconWeather.LIGHT_SNOW
        601 -> IconWeather.SNOW
        602 -> IconWeather.HEAVY_SNOW
        611 -> IconWeather.SLEET
        612 -> IconWeather.LIGHT_SHOWER_SLEET
        613 -> IconWeather.SHOWER_SLEET
        615 -> IconWeather.LIGHT_RAIN_AND_SNOW
        616 -> IconWeather.RAIN_AND_SNOW
        620 -> IconWeather.LIGHT_SHOWER_SNOW
        621 -> IconWeather.SHOWER_SNOW
        622 -> IconWeather.HEAVY_SHOWER_SNOW
        701 -> IconWeather.MIST
        711 -> IconWeather.SMOKE
        721 -> IconWeather.HAZE
        731 -> IconWeather.SAND_DUST_WHIRLS
        741 -> IconWeather.FOG
        751 -> IconWeather.SAND
        761 -> IconWeather.DUST
        762 -> IconWeather.VOLCANIC_ASH
        771 -> IconWeather.SQUALLS
        781 -> IconWeather.TORNADO
        800 -> IconWeather.CLEAR_SKY
        801 -> IconWeather.FEW_CLOUDS
        802 -> IconWeather.SCATTERED_CLOUDS
        803 -> IconWeather.BROKEN_CLOUDS
        804 -> IconWeather.OVERCAST_CLOUDS
        else -> null
    }
}

fun owApiIconToIntResourceDay(iconWeather: IconWeather, isNight: Boolean): Int {
    return when {
        (iconWeather == IconWeather.THUNDERSTORM && isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.THUNDERSTORM && !isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.LIGHT_THUNDERSTORM && isNight) -> R.drawable.tstorm1_night
        (iconWeather == IconWeather.LIGHT_THUNDERSTORM && !isNight) -> R.drawable.tstorm1
        (iconWeather == IconWeather.THUNDERSTORM_WITH_LIGHT_RAIN && isNight) -> R.drawable.tstorm1_night
        (iconWeather == IconWeather.THUNDERSTORM_WITH_LIGHT_RAIN && !isNight) -> R.drawable.tstorm1
        (iconWeather == IconWeather.THUNDERSTORM_WITH_RAIN && isNight) -> R.drawable.tstorm2_night
        (iconWeather == IconWeather.THUNDERSTORM_WITH_RAIN && !isNight) -> R.drawable.tstorm2
        (iconWeather == IconWeather.THUNDERSTORM_WITH_HEAVY_RAIN && isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.THUNDERSTORM_WITH_HEAVY_RAIN && !isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.HEAVY_THUNDERSTORM && isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.HEAVY_THUNDERSTORM && !isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.RAGGED_THUNDERSTORM && isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.RAGGED_THUNDERSTORM && !isNight) -> R.drawable.tstorm3
        (iconWeather == IconWeather.THUNDERSTORM_WITH_LIGHT_DRIZZLE && isNight) -> R.drawable.tstorm1_night
        (iconWeather == IconWeather.THUNDERSTORM_WITH_LIGHT_DRIZZLE && !isNight) -> R.drawable.tstorm1
        (iconWeather == IconWeather.THUNDERSTORM_WITH_DRIZZLE && isNight) -> R.drawable.tstorm1_night
        (iconWeather == IconWeather.THUNDERSTORM_WITH_DRIZZLE && !isNight) -> R.drawable.tstorm1
        (iconWeather == IconWeather.THUNDERSTORM_WITH_HEAVY_DRIZZLE && isNight) -> R.drawable.tstorm2_night
        (iconWeather == IconWeather.THUNDERSTORM_WITH_HEAVY_DRIZZLE && !isNight) -> R.drawable.tstorm2
        (iconWeather == IconWeather.LIGHT_INTENSITY_DRIZZLE && isNight) -> R.drawable.shower1_night
        (iconWeather == IconWeather.LIGHT_INTENSITY_DRIZZLE && !isNight) -> R.drawable.shower1
        (iconWeather == IconWeather.DRIZZLE && isNight) -> R.drawable.shower1_night
        (iconWeather == IconWeather.DRIZZLE && !isNight) -> R.drawable.shower1
        (iconWeather == IconWeather.HEAVY_INTENSITY_DRIZZLE && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.HEAVY_INTENSITY_DRIZZLE && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.LIGHT_INTENSITY_DRIZZLE_RAIN && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.LIGHT_INTENSITY_DRIZZLE_RAIN && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.DRIZZLE_RAIN && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.DRIZZLE_RAIN && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.HEAVY_INTENSITY_DRIZZLE_RAIN && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.HEAVY_INTENSITY_DRIZZLE_RAIN && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.SHOWER_RAIN_AND_DRIZZLE && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.SHOWER_RAIN_AND_DRIZZLE && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.HEAVY_SHOWER_RAIN_AND_DRIZZLE && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.HEAVY_SHOWER_RAIN_AND_DRIZZLE && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.SHOWER_DRIZZLE && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.SHOWER_DRIZZLE && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.LIGHT_RAIN && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.LIGHT_RAIN && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.MODERATE_RAIN && isNight) -> R.drawable.shower2_night
        (iconWeather == IconWeather.MODERATE_RAIN && !isNight) -> R.drawable.shower2
        (iconWeather == IconWeather.HEAVY_INTENSITY_RAIN && isNight) -> R.drawable.shower3
        (iconWeather == IconWeather.HEAVY_INTENSITY_RAIN && !isNight) -> R.drawable.shower3
        (iconWeather == IconWeather.VERY_HEAVY_RAIN && isNight) -> R.drawable.shower3
        (iconWeather == IconWeather.VERY_HEAVY_RAIN && !isNight) -> R.drawable.shower3
        (iconWeather == IconWeather.EXTREME_RAIN && isNight) -> R.drawable.shower3
        (iconWeather == IconWeather.EXTREME_RAIN && !isNight) -> R.drawable.shower3
        (iconWeather == IconWeather.FREEZING_RAIN && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.FREEZING_RAIN && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_SNOW && isNight) -> R.drawable.snow1_night
        (iconWeather == IconWeather.LIGHT_SNOW && !isNight) -> R.drawable.snow1
        (iconWeather == IconWeather.SNOW && isNight) -> R.drawable.snow2_night
        (iconWeather == IconWeather.SNOW && !isNight) -> R.drawable.snow2
        (iconWeather == IconWeather.HEAVY_SNOW && isNight) -> R.drawable.snow3_night
        (iconWeather == IconWeather.HEAVY_SNOW && !isNight) -> R.drawable.snow3
        (iconWeather == IconWeather.SLEET && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.SLEET && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_SHOWER_SLEET && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_SHOWER_SLEET && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.SHOWER_SLEET && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.SHOWER_SLEET && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_RAIN_AND_SNOW && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_RAIN_AND_SNOW && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.RAIN_AND_SNOW && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.RAIN_AND_SNOW && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_SHOWER_SNOW && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.LIGHT_SHOWER_SNOW && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.SHOWER_SNOW && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.SHOWER_SNOW && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.HEAVY_SHOWER_SNOW && isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.HEAVY_SHOWER_SNOW && !isNight) -> R.drawable.sleet
        (iconWeather == IconWeather.MIST && isNight) -> R.drawable.mist_night
        (iconWeather == IconWeather.MIST && !isNight) -> R.drawable.mist
        (iconWeather == IconWeather.SMOKE && isNight) -> R.drawable.mist_night
        (iconWeather == IconWeather.SMOKE && !isNight) -> R.drawable.mist
        (iconWeather == IconWeather.HAZE && isNight) -> R.drawable.mist_night
        (iconWeather == IconWeather.HAZE && !isNight) -> R.drawable.mist
        (iconWeather == IconWeather.SAND_DUST_WHIRLS && isNight) -> R.drawable.mist_night
        (iconWeather == IconWeather.SAND_DUST_WHIRLS && !isNight) -> R.drawable.mist
        (iconWeather == IconWeather.FOG && isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.FOG && !isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.SAND && isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.SAND && !isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.DUST && isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.DUST && !isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.VOLCANIC_ASH && isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.VOLCANIC_ASH && !isNight) -> R.drawable.fog_night
        (iconWeather == IconWeather.CLEAR_SKY && isNight) -> R.drawable.sunny_night
        (iconWeather == IconWeather.CLEAR_SKY && !isNight) -> R.drawable.sunny
        (iconWeather == IconWeather.FEW_CLOUDS && isNight) -> R.drawable.cloudy1_night
        (iconWeather == IconWeather.FEW_CLOUDS && !isNight) -> R.drawable.cloudy1
        (iconWeather == IconWeather.SCATTERED_CLOUDS && isNight) -> R.drawable.cloudy2_night
        (iconWeather == IconWeather.SCATTERED_CLOUDS && !isNight) -> R.drawable.cloudy2
        (iconWeather == IconWeather.BROKEN_CLOUDS && isNight) -> R.drawable.cloudy3_night
        (iconWeather == IconWeather.BROKEN_CLOUDS && !isNight) -> R.drawable.cloudy3
        (iconWeather == IconWeather.OVERCAST_CLOUDS && isNight) -> R.drawable.cloudy4_night
        (iconWeather == IconWeather.OVERCAST_CLOUDS && !isNight) -> R.drawable.cloudy4
        (iconWeather == IconWeather.SQUALLS && isNight) -> R.drawable.cloudy5
        (iconWeather == IconWeather.SQUALLS && !isNight) -> R.drawable.cloudy5
        (iconWeather == IconWeather.TORNADO && isNight) -> R.drawable.cloudy5
        (iconWeather == IconWeather.TORNADO && !isNight) -> R.drawable.cloudy5
        else -> R.drawable.dunno
    }
}

enum class IconWeather {
    THUNDERSTORM,
    LIGHT_THUNDERSTORM,
    THUNDERSTORM_WITH_LIGHT_RAIN,
    THUNDERSTORM_WITH_RAIN,
    THUNDERSTORM_WITH_HEAVY_RAIN,
    HEAVY_THUNDERSTORM,
    RAGGED_THUNDERSTORM,
    THUNDERSTORM_WITH_LIGHT_DRIZZLE,
    THUNDERSTORM_WITH_DRIZZLE,
    THUNDERSTORM_WITH_HEAVY_DRIZZLE,
    LIGHT_INTENSITY_DRIZZLE,
    DRIZZLE,
    HEAVY_INTENSITY_DRIZZLE,
    LIGHT_INTENSITY_DRIZZLE_RAIN,
    DRIZZLE_RAIN,
    HEAVY_INTENSITY_DRIZZLE_RAIN,
    SHOWER_RAIN_AND_DRIZZLE,
    HEAVY_SHOWER_RAIN_AND_DRIZZLE,
    SHOWER_DRIZZLE,
    LIGHT_RAIN,
    LIGHT_INTENSITY_SHOWER_RAIN,
    SHOWER_RAIN,
    HEAVY_INTENSITY_SHOWER_RAIN,
    RAGGED_SHOWER_RAIN,
    MODERATE_RAIN,
    HEAVY_INTENSITY_RAIN,
    VERY_HEAVY_RAIN,
    EXTREME_RAIN,
    FREEZING_RAIN,
    LIGHT_SNOW,
    SNOW,
    HEAVY_SNOW,
    SLEET,
    LIGHT_SHOWER_SLEET,
    SHOWER_SLEET,
    LIGHT_RAIN_AND_SNOW,
    RAIN_AND_SNOW,
    LIGHT_SHOWER_SNOW,
    SHOWER_SNOW,
    HEAVY_SHOWER_SNOW,
    MIST,
    SMOKE,
    HAZE,
    SAND_DUST_WHIRLS,
    FOG,
    SAND,
    DUST,
    VOLCANIC_ASH,
    CLEAR_SKY,
    FEW_CLOUDS,
    SCATTERED_CLOUDS,
    BROKEN_CLOUDS,
    OVERCAST_CLOUDS,
    SQUALLS,
    TORNADO;
}
