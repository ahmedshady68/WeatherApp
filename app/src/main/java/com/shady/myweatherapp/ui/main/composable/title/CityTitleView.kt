package com.shady.myweatherapp.ui.main.composable.title

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CityTitleView(city: String, currentDate: String) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color.White,
            fontSize = 32.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            text = city
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            text = currentDate
        )
    }
}