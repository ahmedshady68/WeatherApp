package com.shady.domain.entity

data class ForecastResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)