package com.example.fooddelivery.data.model

data class RestaurantCollection(
    val name: String,
    val priority: Int,
    public val restaurants: ArrayList<Restaurant>
)
