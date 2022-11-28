package com.example.fooddelivery.di

import com.example.fooddelivery.data.api.ApiService
import com.example.fooddelivery.data.repository.HomePageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun getApiService(): ApiService{
        return Retrofit.Builder().baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun getHomePageRepository(apiService: ApiService):HomePageRepository{
        return HomePageRepository(apiService)
    }
}