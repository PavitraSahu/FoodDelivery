package com.example.fooddelivery.ui.home.viewstate

import com.example.fooddelivery.data.model.HomePageData

sealed class HomeViewState {
    object Idle: HomeViewState()
    object Loading: HomeViewState()
    class Failure(val failureMsg: String): HomeViewState()
    class Success(val data: HomePageData): HomeViewState()
}
