package com.shady.myweatherapp.ui.main.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shady.myweatherapp.R

@Composable
fun ForecastItemView() {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.sunny_small),
            modifier = Modifier
                .size(32.dp),
            contentDescription = "sunny image"
        )
        Text(
            modifier = Modifier.padding(top = 9.dp), fontSize = 12.sp,
            fontStyle = FontStyle.Normal, color = Color.White,
            fontWeight = FontWeight.Normal, text = "82.4°/86°F"
        )
        Text(
            modifier = Modifier.padding(top = 6.dp), fontSize = 16.sp,
            fontStyle = FontStyle.Normal, color = Color.White,
            fontWeight = FontWeight.SemiBold, text = "Today"
        )
    }

}