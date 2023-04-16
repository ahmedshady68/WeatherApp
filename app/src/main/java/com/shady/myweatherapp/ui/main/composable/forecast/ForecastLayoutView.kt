package com.shady.myweatherapp.ui.main.composable.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shady.domain.entity.Forecastday
import com.shady.myweatherapp.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ForecastLayoutView(forecastDay: List<Forecastday>?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 75.dp, bottom = 25.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ForecastItemView(
            forecastDay?.get(0)?.day?.condition?.icon ?: "",
            forecastDay?.get(0)?.day?.maxtemp_f.toString(),
            forecastDay?.get(0)?.day?.mintemp_f.toString(),
            stringResource(R.string.today_text)
        )
        ForecastItemView(
            forecastDay?.get(1)?.day?.condition?.icon ?: "",
            forecastDay?.get(1)?.day?.maxtemp_f.toString(),
            forecastDay?.get(1)?.day?.mintemp_f.toString(),
            stringResource(R.string.tomorrow_text)
        )
        forecastDay?.get(2)?.date_epoch?.let { dateEpoch ->
            getDayOfWeek(
                dateEpoch.toLong()
            )
        }?.let {
            ForecastItemView(
                forecastDay[2].day.condition.icon ?: "",
                forecastDay[2].day.maxtemp_f.toString(),
                forecastDay[2].day.mintemp_f.toString(),
                it
            )
        }
    }
}

fun getDayOfWeek(timestamp: Long): String {
    return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timestamp * 1000)
}
