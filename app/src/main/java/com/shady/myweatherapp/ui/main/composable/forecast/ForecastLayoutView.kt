package com.shady.myweatherapp.ui.main.composable.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shady.myweatherapp.R
import com.shady.myweatherapp.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ForecastLayoutView(viewModel: WeatherViewModel = hiltViewModel()) {
    val forecastState by viewModel.forecasts.collectAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 118.dp, bottom = 25.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ForecastItemView(
            forecastState?.forecast?.forecastday?.get(0)?.day?.condition?.icon ?: "",
            forecastState?.forecast?.forecastday?.get(0)?.day?.maxtemp_f.toString(),
            forecastState?.forecast?.forecastday?.get(0)?.day?.mintemp_f.toString(),
            stringResource(R.string.today_text)
        )
        ForecastItemView(
            forecastState?.forecast?.forecastday?.get(1)?.day?.condition?.icon ?: "",
            forecastState?.forecast?.forecastday?.get(1)?.day?.maxtemp_f.toString(),
            forecastState?.forecast?.forecastday?.get(1)?.day?.mintemp_f.toString(),
            stringResource(R.string.tomorrow_text)
        )
        forecastState?.forecast?.forecastday?.get(2)?.date_epoch?.let { dateEpoch ->
            getDayOfWeek(
                dateEpoch.toLong()
            )
        }?.let {
            ForecastItemView(
                forecastState?.forecast?.forecastday?.get(2)?.day?.condition?.icon ?: "",
                forecastState?.forecast?.forecastday?.get(2)?.day?.maxtemp_f.toString(),
                forecastState?.forecast?.forecastday?.get(2)?.day?.mintemp_f.toString(),
                it
            )
        }
    }
}

fun getDayOfWeek(timestamp: Long): String {
    return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timestamp * 1000)
}
