package com.fjbg.weather.di

import com.fjbg.weather.data.AQI_BASE_URL
import com.fjbg.weather.data.WEATHER_BASE_URL
import com.fjbg.weather.data.remote.AqiApi
import com.fjbg.weather.data.remote.WeatherApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

    @WeatherBaseUrl
    @Provides
    @Singleton
    fun providesWeatherBaseUrl(): String = WEATHER_BASE_URL


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @WeatherRetrofit
    @Singleton
    @Provides
    fun providesWeatherRetrofit(client: OkHttpClient, @WeatherBaseUrl baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()

    @WeatherService
    @Singleton
    @Provides
    fun providesWeatherServices(@WeatherRetrofit retrofit: Retrofit): WeatherApi =
        retrofit.create(WeatherApi::class.java)


    @AqiBaseUrl
    @Provides
    @Singleton
    fun providesAqiBaseUrl(): String = AQI_BASE_URL


    @AqiRetrofit
    @Singleton
    @Provides
    fun providesAqiRetrofit(client: OkHttpClient, @AqiBaseUrl baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()

    @AqiService
    @Singleton
    @Provides
    fun providesAqiServices(@AqiRetrofit retrofit: Retrofit): AqiApi =
        retrofit.create(AqiApi::class.java)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherBaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherService

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AqiBaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AqiRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AqiService
