package com.shady.myweatherapp.ui.main.composable.forecast

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shady.myweatherapp.ui.main.composable.ForecastItemView

@Composable
fun ForecastLayoutView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding( top = 118.dp, bottom = 25.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ForecastItemView()
        ForecastItemView()
        ForecastItemView()
    }
}