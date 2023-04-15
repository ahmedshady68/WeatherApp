package com.shady.domain.usecase

import com.shady.domain.repo.WeatherRepo

class GetForecast(private val weatherRepo: WeatherRepo) {
    suspend operator fun invoke(city: String) = weatherRepo.getForecastFromRemote(city = city)
}