package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.api.ApiService

class HomePageRepository(val apiService: ApiService) {

    suspend fun getHomePageData() = apiService.getHomePageData()
}