package com.shady.data.remote

import com.shady.data.BuildConfig
import com.shady.domain.entity.ForecastResponse
import com.shady.domain.entity.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("days") types: String = "3",
        @Query("key") key: String = BuildConfig.API_KEY
    ): ForecastResponse

    @GET("search.json")
    suspend fun getSearch(
        @Query("q") city: String, @Query("key") key: String = BuildConfig.API_KEY
    ): SearchResponse
}