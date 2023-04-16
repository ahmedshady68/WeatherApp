package com.shady.myweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.shady.myweatherapp.ui.main.MainScreenView
import com.shady.myweatherapp.ui.theme.MyWeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWeatherAppTheme {
                MainScreenView()
            }
        }
    }
}