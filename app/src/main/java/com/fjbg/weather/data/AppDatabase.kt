package com.fjbg.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.weather.data.local.AqiDao
import com.fjbg.weather.data.local.AqiEntity
import com.fjbg.weather.data.local.WeatherDao
import com.fjbg.weather.data.local.WeatherEntity

@Database(
    entities = [
        WeatherEntity::class,
        AqiEntity::class,
    ],
    version = DB_VERSION,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
    abstract fun aqiDao(): AqiDao
}