package com.shady.myweatherapp.ui.main.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shady.myweatherapp.R

@Composable
fun CurrentWeatherView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 101.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.sunny_big),
            modifier = Modifier
                .size(70.dp),
            contentDescription = "sunny image"
        )
        Text(
            modifier = Modifier.padding(top = 23.dp), fontSize = 56.sp,
            fontStyle = FontStyle.Normal, color = Color.White,
            fontWeight = FontWeight.SemiBold, text = "82.4°F"
        )
        Text(
            modifier = Modifier.padding(top = 18.dp), fontSize = 16.sp,
            fontStyle = FontStyle.Normal, color = Color.White,
            fontWeight = FontWeight.Normal, text = "It’s a sunny day. "
        )
        HumidityLayoutView("60%","3 mph")
    }

}