package com.fjbg.weather.di

import android.content.Context
import androidx.room.Room
import com.fjbg.weather.data.DB_NAME
import com.fjbg.weather.data.local.WeatherDao
import com.fjbg.weather.data.local.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context): WeatherDatabase {
        return Room.databaseBuilder(
            appContext,
            WeatherDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    fun providesWeatherDao(database: WeatherDatabase): WeatherDao = database.weatherDao()

}