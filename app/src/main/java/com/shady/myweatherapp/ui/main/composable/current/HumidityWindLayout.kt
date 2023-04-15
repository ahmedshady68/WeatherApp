package com.shady.myweatherapp.ui.main.composable.current

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shady.myweatherapp.ui.main.composable.spacers.SpaceHorizontal43

@Composable
fun HumidityLayoutView(humidity: String, wind: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 18.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WindView(wind)
        SpaceHorizontal43()
        HumidityView(humidity)
    }
}