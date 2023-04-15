package com.shady.myweatherapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.entity.ForecastResponse
import com.shady.domain.entity.search.SearchResponse
import com.shady.domain.usecase.GetForecast
import com.shady.domain.usecase.GetSearch
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
) :
    ViewModel() {
    private val _forecasts: MutableStateFlow<ForecastResponse?> = MutableStateFlow(null)
    val forecasts: StateFlow<ForecastResponse?> = _forecasts.asStateFlow()

    private val _search: MutableStateFlow<SearchResponse?> = MutableStateFlow(null)
    val search: StateFlow<SearchResponse?> = _search.asStateFlow()

    fun getForecast(city: String) {
        viewModelScope.launch() {
            try {
                val forecast = getForecastUseCase.invoke(city)
                _forecasts.value = forecast
            } catch (e: Exception) {
                Log.e("forecastViewModel", e.message.toString())
            }
        }
    }

    fun getSearch(city: String) {
        viewModelScope.launch() {
            try {
                val searchData = getSearchUseCase.invoke(city)
                _search.value = searchData
            } catch (e: Exception) {
                Log.e("searchViewModel", e.message.toString())
            }
        }
    }

    fun getTime(): String {
        var output: String = ""
        viewModelScope.launch() {
            try {
                val time = _forecasts.value?.location?.localtime
                val parser = SimpleDateFormat("yyyy-MM-dd HH:mm")
                val formatter = SimpleDateFormat("HH:mm")
                 output = formatter.format(parser.parse(time))
            } catch (e: Exception) {
                Log.e("forecastViewModel", e.message.toString())
            }
        }
        return output
    }

    fun getDayOfTheWeek(): String {
        var output: String = ""
        viewModelScope.launch() {
            try {
                val time = _forecasts.value?.location?.localtime
                val sdf = SimpleDateFormat(time)
                val date = Date()
                val dayOfTheWeek = sdf.format(date)
                output = dayOfTheWeek
            } catch (e: Exception) {
                Log.e("forecastViewModel", e.message.toString())
            }
        }
        return output
    }

}