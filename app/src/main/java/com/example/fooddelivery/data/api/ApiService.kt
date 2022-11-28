package com.example.fooddelivery.data.api

import com.example.fooddelivery.data.model.HomePageData
import retrofit2.http.GET

interface ApiService {

    @GET("v1/0c5d380f-972a-44c9-bd11-ca5a2f154019")
    suspend fun getHomePageData(): HomePageData

}