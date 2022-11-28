package com.example.fooddelivery.data.model

data class Data(
    val banners: ArrayList<Banner>,
    val food_categories: ArrayList<FoodCategory>,
    val number_of_active_vouchers: Int,
    val offer_collections: ArrayList<OfferCollection>,
    val restaurant_collections: ArrayList<RestaurantCollection>
)