package com.fjbg.weather.util

import android.icu.util.Calendar
import android.text.format.DateFormat
import java.util.*


fun Long.toDate(): String {
    val calendar = Calendar.getInstance(Locale.getDefault())
    calendar.timeInMillis = this * 1000
    return DateFormat.format("E, dd MMM yyyy", calendar.timeInMillis).toString()
}
