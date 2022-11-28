package com.example.fooddelivery.data.model

data class Restaurant(
    val additional_offer: String,
    val display_distance: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val offers: List<Offer>,
    val rating: Double
)