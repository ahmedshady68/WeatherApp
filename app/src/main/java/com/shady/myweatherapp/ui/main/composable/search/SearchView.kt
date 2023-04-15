package com.shady.myweatherapp.ui.main.composable.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shady.domain.entity.search.SearchResponse
import com.shady.myweatherapp.R

@Composable
fun SearchView(
    searchListResult: SearchResponse?,
    onClickSearch: (String) -> Unit,
    onClickCity: (String) -> Unit,
    isSearchViewDisplayed: Boolean,
    onSearchViewVisibilityChange: () -> Unit
) {

    SearchContent(
        isSearchViewDisplayed = isSearchViewDisplayed,
        searchListResult = searchListResult,
        onClickSearch = onClickSearch,
        onClickCity = onClickCity,
        onSearchViewVisibilityChange = onSearchViewVisibilityChange)
}

@Composable
fun SearchContent(
    searchListResult: SearchResponse?,
    onClickSearch: (String) -> Unit,
    onClickCity: (String) -> Unit,
    isSearchViewDisplayed: Boolean,
    onSearchViewVisibilityChange: () -> Unit,
) {
    var searchText by remember {
        mutableStateOf("")
    }
    var searchButtonClick by remember {
        mutableStateOf(false)
    }
    var cardRounded by remember {
        mutableStateOf(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp))
    }
    if (isSearchViewDisplayed){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(), shape = cardRounded
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, end = 32.dp, top = 27.dp, bottom = 27.dp)
                    .background(Color.White)
            ) {
                IconButton(onClick = {
                    if (searchText.isNotEmpty()) {
                        searchButtonClick = searchText.isNotEmpty()
                        cardRounded = RoundedCornerShape(bottomEnd = 0.dp, bottomStart = 0.dp)
                        onClickSearch(searchText)
                    }
                }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.arrow_go_search_button),
                        contentDescription = "close",
                        tint = Color.Black
                    )
                }
                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 1.dp, color = Color.Black, shape = RoundedCornerShape(15.dp)
                    ),
                    value = searchText,
                    onValueChange = {
                        searchText = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        cursorColor = Color.Black
                    ),
                    textStyle = TextStyle(
                        color = Color.Black, fontSize = 16.sp
                    ),
                    label = { Text(text = "Search City", color = Color.Black) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
                    ),
                    singleLine = true,
                    trailingIcon = {
                        if (searchText.isNotEmpty()) {
                            IconButton(onClick = {
                                searchButtonClick = false
                                cardRounded =
                                    RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
                                searchText = ""
                            }) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = "close",
                                    tint = Color.Black
                                )
                            }
                        }
                    })
            }
        }
        AnimatedVisibility(visible = searchButtonClick) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
            ) {
                Column {
                    LazyColumn(
                        modifier = Modifier.heightIn(max = 150.dp),
                    ) {
                        if (searchText.isNotEmpty()) {
                            if (searchListResult != null) {
                                items(
                                    searchListResult.toList()
                                ) {
                                    CategoryItems(title = it.name, subTitle = it.region) { title ->
                                        searchText = title
                                        searchButtonClick = false
                                        onSearchViewVisibilityChange.invoke()
                                        cardRounded =
                                            RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
                                        onClickCity(title)
                                    }
                                }
                            }
                        }
                    }
                    IconButton(
                        onClick = {
                            searchButtonClick = false
                            cardRounded = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = "arrow",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}}