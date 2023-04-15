package com.shady.domain.repo

import com.shady.domain.entity.ForecastResponse
import com.shady.domain.entity.search.SearchResponse

interface WeatherRepo {
    suspend fun getForecastFromRemote(city: String): ForecastResponse
    suspend fun getSearchFromRemote(city: String): SearchResponse
}