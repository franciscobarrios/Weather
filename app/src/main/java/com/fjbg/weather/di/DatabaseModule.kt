package com.fjbg.weather.di

import android.content.Context
import androidx.room.Room
import com.fjbg.weather.data.AppDatabase
import com.fjbg.weather.data.DB_NAME
import com.fjbg.weather.data.local.AqiDao
import com.fjbg.weather.data.local.WeatherDao
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
    fun providesDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room
            .databaseBuilder(
                appContext,
                AppDatabase::class.java,
                DB_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesWeatherDao(database: AppDatabase): WeatherDao = database.weatherDao()

    @Provides
    fun providesAqiDao(database: AppDatabase): AqiDao = database.aqiDao()
}