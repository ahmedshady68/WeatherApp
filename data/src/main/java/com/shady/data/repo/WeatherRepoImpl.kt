package com.shady.data.repo

import com.shady.data.remote.ApiService
import com.shady.domain.entity.ForecastResponse
import com.shady.domain.entity.search.SearchResponse
import com.shady.domain.repo.WeatherRepo

class WeatherRepoImpl(private val apiService: ApiService) : WeatherRepo {
    override suspend fun getForecastFromRemote(city: String): ForecastResponse = apiService.getForecast(city)

    override suspend fun getSearchFromRemote(city: String): SearchResponse = apiService.getSearch(city)
}