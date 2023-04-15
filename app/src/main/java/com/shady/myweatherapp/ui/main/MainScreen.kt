package com.shady.myweatherapp.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shady.myweatherapp.Greeting
import com.shady.myweatherapp.ui.main.composable.BackgroundView
import com.shady.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun MainScreenView() {
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundView()
        ContentView()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyWeatherAppTheme {
        Greeting("Android")
    }
}