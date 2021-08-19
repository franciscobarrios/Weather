package com.fjbg.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {

    @Query("SELECT * FROM WeatherEntity")
    suspend fun getCurrentWeather(): WeatherEntity?

    @Query("SELECT currentTemp FROM WeatherEntity")
    suspend fun getCurrentTemperature(): Double?

    @Query("SELECT weatherMain FROM WeatherEntity")
    suspend fun getDescriptionMain(): String?

    @Query("SELECT weatherDescription FROM WeatherEntity")
    suspend fun getDescription(): String?

    @Query("SELECT humidity FROM WeatherEntity")
    suspend fun getHumidity(): Double?

    @Query("SELECT cityName FROM WeatherEntity")
    suspend fun getCity(): String?

    @Query("SELECT country FROM WeatherEntity")
    suspend fun getCountry(): String?

    @Query("SELECT dt FROM WeatherEntity")
    suspend fun getDate(): Long?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(entity: WeatherEntity)

    @Query("DELETE FROM WeatherEntity")
    suspend fun clearData()
}