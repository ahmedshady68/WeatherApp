package com.shady.myweatherapp.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.shady.myweatherapp.WeatherViewModel
import com.shady.myweatherapp.ui.main.composable.title.CityTitleView
import com.shady.myweatherapp.ui.main.composable.current.CurrentWeatherView
import com.shady.myweatherapp.ui.main.composable.forecast.ForecastLayoutView
import com.shady.myweatherapp.ui.main.composable.time.TimeSearchView
import com.shady.myweatherapp.ui.main.spacers.spaceVertical24

@Composable
fun BoxWithLayout(content: @Composable ColumnScope.() -> Unit) {
    Column {
        content()
    }
}

@Composable
fun ContentView(viewModel: WeatherViewModel = hiltViewModel()) {
    val searchState by viewModel.search.collectAsState()
    val forecastState by viewModel.forecasts.collectAsState()
    BoxWithLayout {
        Column(verticalArrangement = Arrangement.Top) {
            TimeSearchView(viewModel.getTime(), searchState, { searchText ->
                viewModel.getSearch(searchText)
            }) { citySelected ->
                viewModel.getForecast(citySelected)
            }
            // SearchView()
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {
                spaceVertical24()
                CityTitleView(forecastState?.location?.name ?: "", viewModel.getDayOfTheWeek() ?: "")
                CurrentWeatherView()
                ForecastLayoutView()
            }
        }
    }
}