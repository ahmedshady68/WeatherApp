package com.shady.myweatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.entity.ForecastResponse
import com.shady.domain.entity.search.SearchResponse
import com.shady.domain.usecase.GetForecast
import com.shady.domain.usecase.GetSearch
import com.shady.myweatherapp.ui.state.ForecastSealedState
import com.shady.myweatherapp.ui.state.SearchSealedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getForecastUseCase: GetForecast,
    private val getSearchUseCase: GetSearch
) : ViewModel() {
    private val _forecasts: MutableStateFlow<ForecastResponse?> = MutableStateFlow(null)
    val forecasts: StateFlow<ForecastResponse?> = _forecasts.asStateFlow()

    private val _search: MutableStateFlow<SearchResponse?> = MutableStateFlow(null)
    val search: StateFlow<SearchResponse?> = _search.asStateFlow()

    val forecastResponseState =
        MutableStateFlow<ForecastSealedState>(value = ForecastSealedState.START)
    val searchResponseState = MutableStateFlow<SearchSealedState>(value = SearchSealedState.START)

    init {
        getForecast(city = "London")
    }

    fun getForecast(city: String) = viewModelScope.launch() {
        this@WeatherViewModel.forecastResponseState.value = ForecastSealedState.LOADING
        try {
            val forecast = getForecastUseCase.invoke(city)
            _forecasts.value = forecast
            forecastResponseState.value = ForecastSealedState.SUCCESS(forecast)
        } catch (e: Exception) {
            forecastResponseState.value =
                ForecastSealedState.FAILURE(e.localizedMessage?.toString() ?: "")
        }
    }

    fun getSearch(city: String) = viewModelScope.launch() {
        this@WeatherViewModel.searchResponseState.value = SearchSealedState.LOADING
        try {
            val searchData = getSearchUseCase.invoke(city)
            _search.value = searchData
            searchResponseState.value = SearchSealedState.SUCCESS(searchData)
        } catch (e: Exception) {
            searchResponseState.value =
                SearchSealedState.FAILURE(e.localizedMessage?.toString() ?: "")
        }
    }

    fun getTodayTime(): String {
        return SimpleDateFormat(
            "hh:mm aaa",
            Locale.ENGLISH
        ).format(_forecasts.value?.location?.localtime_epoch?.toLong()?.times(1000) ?: 0)
    }

    fun getDayOfTheWeek(): String {
        return SimpleDateFormat(
            "EEEE, d MMMM yyyy",
            Locale.ENGLISH
        ).format(_forecasts.value?.location?.localtime_epoch?.toLong()?.times(1000) ?: 0)
    }
}