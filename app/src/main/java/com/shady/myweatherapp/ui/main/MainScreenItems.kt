package com.shady.myweatherapp.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shady.myweatherapp.R
import com.shady.myweatherapp.WeatherViewModel
import com.shady.myweatherapp.ui.main.composable.current.CurrentWeatherView
import com.shady.myweatherapp.ui.main.composable.forecast.ForecastLayoutView
import com.shady.myweatherapp.ui.main.composable.spacers.SpaceVertical24
import com.shady.myweatherapp.ui.main.composable.time.TimeSearchView
import com.shady.myweatherapp.ui.main.composable.title.CityTitleView
import com.shady.myweatherapp.ui.state.ForecastSealedState
import com.shady.myweatherapp.ui.state.SearchSealedState

@Composable
fun ContentView() {
    CheckForecastResponseStates()
}

@Composable
fun ContentFirstView(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val searchState by viewModel.search.collectAsStateWithLifecycle()
    val forecastState by viewModel.forecasts.collectAsStateWithLifecycle()
    CheckSearchResponseStates()
    BoxWithLayout {
        Column(verticalArrangement = Arrangement.Top) {
            TimeSearchView(viewModel.getTodayTime(), searchState, { searchText ->
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
                SpaceVertical24()
                CityTitleView(
                    forecastState?.location?.name ?: "",
                    viewModel.getDayOfTheWeek() ?: ""
                )
                CurrentWeatherView(forecastState?.current)
                ForecastLayoutView(forecastState?.forecast?.forecastday)
            }
        }
    }
}

@Composable
fun BoxWithLayout(content: @Composable ColumnScope.() -> Unit) {
    Column {
        content()
    }
}

@Composable
fun CheckSearchResponseStates(viewModel: WeatherViewModel = hiltViewModel()) {
    val state by viewModel.searchResponseState.collectAsStateWithLifecycle()
    when (state) {
        SearchSealedState.LOADING -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
        is SearchSealedState.FAILURE -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = stringResource(R.string.error_message), fontSize = 16.sp)
            }
        }
        else -> {
            // no impl
        }
    }
}

@Composable
fun CheckForecastResponseStates(viewModel: WeatherViewModel = hiltViewModel()) {
    val state by viewModel.forecastResponseState.collectAsStateWithLifecycle()
    when (state) {
        ForecastSealedState.LOADING -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
        is ForecastSealedState.FAILURE -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(R.string.error_message),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
        is ForecastSealedState.SUCCESS -> {
            ContentFirstView()
        }
        else -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(R.string.unknown_error),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}