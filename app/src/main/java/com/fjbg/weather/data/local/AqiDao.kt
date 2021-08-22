package com.fjbg.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AqiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAqi(entity: AqiEntity)

    @Query("SELECT aqi FROM air_quality_index")
    fun getCurrentAqi(): Flow<Int?>

    @Query("DELETE FROM air_quality_index")
    suspend fun clearData()
}