package com.shady.myweatherapp.di

import com.shady.domain.repo.WeatherRepo
import com.shady.domain.usecase.GetForecast
import com.shady.domain.usecase.GetSearch
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideForecastUseCase (weatherRepo: WeatherRepo): GetForecast {
        return GetForecast(weatherRepo)
    }

    @Provides
    fun provideSearchUseCase (weatherRepo: WeatherRepo): GetSearch{
        return GetSearch(weatherRepo)
    }
}