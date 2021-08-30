package com.fjbg.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.weather.data.local.*

@Database(
    entities = [
        WeatherEntity::class,
        AqiEntity::class,
        CityEntity::class,
    ],
    version = DB_VERSION,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
    abstract fun aqiDao(): AqiDao
    abstract fun cityDao(): CityDao
}