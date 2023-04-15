package com.shady.myweatherapp.ui.main.composable.current

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.shady.myweatherapp.R
import com.shady.myweatherapp.WeatherViewModel

@Composable
fun CurrentWeatherView(viewModel: WeatherViewModel = hiltViewModel()) {
    val forecastState by viewModel.forecasts.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https:${forecastState?.current?.condition?.icon}"),
            modifier = Modifier
                .size(70.dp),
            contentDescription = "sunny image"
        )
        Text(
            modifier = Modifier.padding(top = 18.dp),
            fontSize = 56.sp,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            text = String.format("%s%s", forecastState?.current?.temp_f.toString(), stringResource(R.string.temperature_mark))
        )
        Text(
            modifier = Modifier.padding(top = 13.dp),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            text = forecastState?.current?.condition?.text.toString()
        )
        HumidityLayoutView(
            forecastState?.current?.humidity.toString(),
            forecastState?.current?.wind_mph.toString()
        )
    }

}