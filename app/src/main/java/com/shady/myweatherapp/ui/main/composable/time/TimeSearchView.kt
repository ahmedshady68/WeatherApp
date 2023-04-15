package com.shady.myweatherapp.ui.main.composable.time

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shady.domain.entity.search.SearchResponse
import com.shady.myweatherapp.R
import com.shady.myweatherapp.ui.main.composable.search.SearchView
import com.shady.myweatherapp.ui.main.spacers.spaceVertical24

@Composable
fun TimeSearchView(
    time: String,
    searchListResult: SearchResponse?,
    onClickSearch: (String) -> Unit,
    onClickCity: (String) -> Unit
) {
    var isSearchViewDisplayed by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        spaceVertical24()
        Text(
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            text = time
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            IconButton(onClick = { isSearchViewDisplayed = true }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "search",
                    tint = Color.White
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(visible = isSearchViewDisplayed) {
                SearchView(
                    searchListResult = searchListResult,
                    onClickSearch = onClickSearch,
                    onClickCity = onClickCity
                )
            }
        }
    }
}