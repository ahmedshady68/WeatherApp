package com.shady.data.remote

import com.shady.domain.entity.ForecastResponse
import com.shady.domain.entity.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast.json?key=ebe27d30d05242589c3144652230704 &days=3")
    suspend fun getForecast(@Query("q") city: String): ForecastResponse

    @GET("search.json?key=ebe27d30d05242589c3144652230704")
    suspend fun getSearch(@Query("q") city: String): SearchResponse
}