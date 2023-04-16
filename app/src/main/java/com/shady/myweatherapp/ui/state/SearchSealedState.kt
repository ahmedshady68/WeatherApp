package com.shady.myweatherapp.ui.state

import com.shady.domain.entity.search.SearchResponse

sealed class SearchSealedState {
    object START : SearchSealedState()
    object LOADING : SearchSealedState()
    data class SUCCESS(val searchResponse: SearchResponse) : SearchSealedState()
    data class FAILURE(val message: String) : SearchSealedState()
}