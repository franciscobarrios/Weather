package com.fjbg.weather.di

import com.fjbg.weather.data.repository.WeatherRepository
import com.fjbg.weather.data.repository.WeatherRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providesWeatherRepositoryImp(repository: WeatherRepositoryImp): WeatherRepository
}