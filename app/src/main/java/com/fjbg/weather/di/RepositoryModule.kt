package com.fjbg.weather.di

import com.fjbg.weather.data.aqi.repository.AqiRepository
import com.fjbg.weather.data.aqi.repository.AqiRepositoryImp
import com.fjbg.weather.data.weather.repository.WeatherRepository
import com.fjbg.weather.data.weather.repository.WeatherRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providesWeatherRepositoryImp(repository: WeatherRepositoryImp): WeatherRepository

    @Binds
    fun providesAqiRepositoryImp(repository: AqiRepositoryImp): AqiRepository
}