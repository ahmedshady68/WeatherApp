package com.shady.myweatherapp.ui.main.composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shady.myweatherapp.ui.main.composable.current.HumidityView
import com.shady.myweatherapp.ui.main.composable.current.WindView
import com.shady.myweatherapp.ui.main.spacers.spaceHorizontal43

@Composable
fun HumidityLayoutView(humidity: String,wind: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 18.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WindView(wind)
        spaceHorizontal43()
        HumidityView(humidity)
    }
}