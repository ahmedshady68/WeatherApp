package com.shady.domain.usecase

import com.shady.domain.repo.WeatherRepo

class GetSearch(private val weatherRepo: WeatherRepo) {
    suspend operator fun invoke(city: String) = weatherRepo.getSearchFromRemote(city = city)
}