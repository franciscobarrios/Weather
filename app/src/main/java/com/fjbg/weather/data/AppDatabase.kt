package com.fjbg.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.weather.data.aqi.local.AqiDao
import com.fjbg.weather.data.aqi.local.AqiEntity
import com.fjbg.weather.data.weather.local.WeatherDao
import com.fjbg.weather.data.weather.local.WeatherEntity

@Database(
    entities = [
        WeatherEntity::class,
        AqiEntity::class,
    ],
    version = 3,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
    abstract fun aqiDao(): AqiDao
}