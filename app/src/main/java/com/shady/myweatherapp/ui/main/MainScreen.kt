package com.shady.myweatherapp.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shady.myweatherapp.ui.main.composable.BackgroundView

@Composable
fun MainScreenView() {
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundView()
        ContentView()
    }
}