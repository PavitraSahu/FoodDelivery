package com.example.fooddelivery.data.model.home_recyclerview_model

import com.example.fooddelivery.data.model.*

sealed class HomeRecyclcerViewItem {

    class BannersList(val bannerList: ArrayList<Banner>?) : HomeRecyclcerViewItem()

    class FoodCategoryList(val foodCategoryList: ArrayList<FoodCategory>?) : HomeRecyclcerViewItem()

    class ActiveVouchers(val value:Int?):HomeRecyclcerViewItem()

    class OfferCollectionList(val offerCollectionList: ArrayList<OfferCollection>?) : HomeRecyclcerViewItem()

    class RestaurantCollection(val restaurantCollection: com.example.fooddelivery.data.model.RestaurantCollection?) : HomeRecyclcerViewItem()
}
