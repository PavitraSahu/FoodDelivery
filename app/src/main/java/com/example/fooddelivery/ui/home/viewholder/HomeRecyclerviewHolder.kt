package com.example.fooddelivery.ui.home.viewholder

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.RestaurantCollection
import com.example.fooddelivery.data.model.home_recyclerview_model.HomeRecyclcerViewItem
import com.example.fooddelivery.databinding.*
import com.example.fooddelivery.ui.home.adapter.BannerViewAdapter
import com.example.fooddelivery.ui.home.adapter.CollectionViewAdapter
import com.example.fooddelivery.ui.home.adapter.FoodCategoryViewAdapter
import com.example.fooddelivery.ui.home.adapter.RestaurantViewAdapter

sealed class HomeRecyclerviewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class BannersViewHolder(private val bannersBinding: HomeRecyclerviewBannerBinding) :
        HomeRecyclerviewHolder(bannersBinding) {
        private val bannerViewAdapter = BannerViewAdapter()

        init {
            bannersBinding!!.bannerRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = bannerViewAdapter
            }
        }

        fun bind(banners: HomeRecyclcerViewItem.BannersList) {
            bannerViewAdapter.addBannerItems(banners.bannerList!!)
        }
    }

    class FoodCategoryViewHolder(private val foodCategoryBinding: HomeRecyclerviewFoodcategoriesBinding) :
        HomeRecyclerviewHolder(foodCategoryBinding) {

        private val foodCategoryViewAdapter = FoodCategoryViewAdapter()

        init {
            foodCategoryBinding!!.foodCategoryRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = foodCategoryViewAdapter
            }
        }

        fun bind(foodCategory: HomeRecyclcerViewItem.FoodCategoryList) {
            foodCategoryViewAdapter.addFoodCategoryItems(foodCategory.foodCategoryList!!)
        }
    }

    class ActiveVouchersViewHolder(private val activeVouchersBinding: HomeRecyclerviewActivevouchersBinding) :
        HomeRecyclerviewHolder(activeVouchersBinding) {
        fun bind(activeVouchers: HomeRecyclcerViewItem.ActiveVouchers) {
            //bind the data with the view
            activeVouchersBinding.textView.text = "   You have ${activeVouchers.value} voucher here"
            activeVouchersBinding.textView.setTextColor(activeVouchersBinding.root.resources.getColor(
                R.color.voucher_text_color,
                null));
        }
    }

    class CollectionViewHolder(private val collectionBinding: HomeRecyclerviewCollectionsBinding) :
        HomeRecyclerviewHolder(collectionBinding) {
        private val collectionViewAdapter = CollectionViewAdapter()

        init {
            collectionBinding!!.collectionsRecyclerview.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = collectionViewAdapter
            }
        }

        fun bind(collection: HomeRecyclcerViewItem.OfferCollectionList) {
            collectionViewAdapter.addCollectionItems(collection.offerCollectionList!!)
        }
    }

    class RestaurantsViewHolder(private val restaurantBinding: HomeRecyclerviewRestaurantBinding) :
        HomeRecyclerviewHolder(restaurantBinding) {
        private val restaurantViewAdapter = RestaurantViewAdapter()

        init {
            restaurantBinding!!.restaurantRecyclerview.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = restaurantViewAdapter
            }
        }

        fun bind(restaurantCollection: HomeRecyclcerViewItem.RestaurantCollection) {
            restaurantBinding.restaurantCollection = restaurantCollection.restaurantCollection
            restaurantViewAdapter.addRestaurants(restaurantCollection.restaurantCollection!!.restaurants!!)
        }
    }

}
