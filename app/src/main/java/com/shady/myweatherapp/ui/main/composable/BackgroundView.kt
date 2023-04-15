package com.shady.myweatherapp.ui.main.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.shady.myweatherapp.R

@Composable
fun BackgroundView() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds,
            contentDescription = "",
            modifier = Modifier
                .matchParentSize()
        )
        Image(
            painter = painterResource(id = R.drawable.gradient),
            contentScale = ContentScale.FillBounds,
            contentDescription = "",
            modifier = Modifier
                .matchParentSize()
                .alpha(alpha = 0.83f)
        )
    }
}