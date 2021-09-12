package com.fjbg.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CityWeatherDao {

    @Query("SELECT * FROM city_weather WHERE active=1 ORDER BY city")
    fun getCityWeatherList(): Flow<List<CityWeatherEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCityWeather(entity: CityWeatherEntity)

    @Query("UPDATE city_weather SET temperature=:temperature, humidity=:humidity, wind=:wind WHERE id=:id")
    suspend fun updateCurrentWeather(
        id: Int,
        temperature: Double,
        humidity: Double,
        wind: Double
    )

    @Query("DELETE FROM city_weather WHERE id=:id")
    suspend fun deleteCityWeather(id: Int)

    @Query("UPDATE city_weather SET isFavorite=:isFavorite WHERE id=:id")
    suspend fun setAsFavorite(id: Int, isFavorite: Int)

}