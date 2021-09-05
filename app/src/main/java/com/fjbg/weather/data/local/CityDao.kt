package com.fjbg.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {

    @Query("SELECT * FROM city")
    fun getCities(): Flow<List<CityEntity>?>

    @Query("SELECT * FROM city WHERE name = :name")
    fun getCityByName(name: String): Flow<List<CityEntity>>

    @Query("SELECT * FROM city WHERE country = :country")
    fun getCityByCountry(country: String): Flow<List<CityEntity>>

    @Query("DELETE FROM city")
    suspend fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCity(city: CityEntity)

    @Query("DELETE FROM city WHERE id=:id")
    suspend fun deleteCityById(id: Int)
}