package com.shady.myweatherapp.ui.state

import com.shady.domain.entity.ForecastResponse

sealed class ForecastSealedState {
    object START : ForecastSealedState()
    object LOADING : ForecastSealedState()
    data class SUCCESS(val forecastResponse: ForecastResponse) : ForecastSealedState()
    data class FAILURE(val message: String) : ForecastSealedState()
}