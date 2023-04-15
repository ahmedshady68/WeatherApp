package com.shady.myweatherapp.di

import com.shady.data.remote.ApiService
import com.shady.data.repo.WeatherRepoImpl
import com.shady.domain.repo.WeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(apiService: ApiService): WeatherRepo {
        return WeatherRepoImpl(apiService)
    }
}