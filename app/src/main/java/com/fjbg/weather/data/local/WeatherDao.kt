package com.fjbg.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM WeatherEntity")
    suspend fun getCurrentWeather(): WeatherEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(entity: WeatherEntity)

    @Query("DELETE FROM WeatherEntity")
    suspend fun clearData()
}