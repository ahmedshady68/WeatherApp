package com.shady.myweatherapp.ui.main.composable.current

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shady.myweatherapp.R

@Composable
fun WindView(wind: String) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.wind),
            modifier = Modifier
                .width(17.dp)
                .height(14.dp),
            contentDescription = stringResource(R.string.wind_content_description)
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(CenterVertically), fontSize = 12.sp,
            fontStyle = FontStyle.Normal, color = Color.White,
            fontWeight = FontWeight.Normal, text = String.format("%S %S", wind, stringResource(R.string.wind_unit))
        )
    }
}