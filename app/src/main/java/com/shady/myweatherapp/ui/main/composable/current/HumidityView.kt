package com.shady.myweatherapp.ui.main.composable.current

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
fun HumidityView(humidity: String) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.sunny_small),
            modifier = Modifier
                .size(32.dp),
            contentDescription = "Humidity image"
        )
        Text(
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically), fontSize = 12.sp,
            fontStyle = FontStyle.Normal, color = Color.White,
            fontWeight = FontWeight.Normal, text = humidity
        )
    }
}