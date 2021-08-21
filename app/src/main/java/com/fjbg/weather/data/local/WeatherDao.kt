package com.fjbg.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM WeatherEntity")
    suspend fun getCurrentWeather(): WeatherEntity?

    @Query("SELECT currentTemp FROM WeatherEntity")
    fun getCurrentTemperature(): Flow<Double?>

    @Query("SELECT weatherMain FROM WeatherEntity")
    fun getDescriptionMain(): Flow<String?>

    @Query("SELECT weatherDescription FROM WeatherEntity")
    fun getDescription(): Flow<String?>

    @Query("SELECT humidity FROM WeatherEntity")
    fun getHumidity(): Flow<Double?>

    @Query("SELECT cityName FROM WeatherEntity")
    fun getCity(): Flow<String?>

    @Query("SELECT country FROM WeatherEntity")
    fun getCountry(): Flow<String?>

    @Query("SELECT dt FROM WeatherEntity")
    fun getDate(): Flow<Long?>

    @Query("SELECT weatherIcon FROM WeatherEntity")
    fun getIcon(): Flow<String?>

    @Query("SELECT weatherIconId FROM WeatherEntity")
    fun getIconId(): Flow<Int?>

    @Query("SELECT windSpeed FROM WeatherEntity")
    fun getWindSpeed(): Flow<Double?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(entity: WeatherEntity)

    @Query("DELETE FROM WeatherEntity")
    suspend fun clearData()
}