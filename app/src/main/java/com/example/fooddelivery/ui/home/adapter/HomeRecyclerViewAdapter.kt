package com.example.fooddelivery.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.home_recyclerview_model.HomeRecyclcerViewItem
import com.example.fooddelivery.data.model.home_recyclerview_model.HomeRecyclcerViewItem.*
import com.example.fooddelivery.databinding.*
import com.example.fooddelivery.ui.home.viewholder.HomeRecyclerviewHolder

class HomeRecyclerViewAdapter() : RecyclerView.Adapter<HomeRecyclerviewHolder>() {

    var items = ArrayList<HomeRecyclcerViewItem>()

        fun addItems(list: ArrayList<HomeRecyclcerViewItem>) {
            items = list
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerviewHolder {
        return when(viewType){
            R.layout.home_recyclerview_banner -> HomeRecyclerviewHolder.BannersViewHolder(
                HomeRecyclerviewBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.home_recyclerview_foodcategories -> HomeRecyclerviewHolder.FoodCategoryViewHolder(
                HomeRecyclerviewFoodcategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.home_recyclerview_activevouchers -> HomeRecyclerviewHolder.ActiveVouchersViewHolder(
                HomeRecyclerviewActivevouchersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.home_recyclerview_collections -> HomeRecyclerviewHolder.CollectionViewHolder(
                HomeRecyclerviewCollectionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.home_recyclerview_restaurant -> HomeRecyclerviewHolder.RestaurantsViewHolder(
                HomeRecyclerviewRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid viewType received")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerviewHolder, position: Int) {
        val item = items [position];
        when(holder){
            is HomeRecyclerviewHolder.BannersViewHolder -> holder.bind(item as BannersList)
            is HomeRecyclerviewHolder.FoodCategoryViewHolder -> holder.bind(item as FoodCategoryList)
            is HomeRecyclerviewHolder.ActiveVouchersViewHolder -> holder.bind(item as ActiveVouchers)
            is HomeRecyclerviewHolder.CollectionViewHolder -> holder.bind(item as OfferCollectionList)
            is HomeRecyclerviewHolder.RestaurantsViewHolder -> holder.bind(item as RestaurantCollection)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is BannersList -> R.layout.home_recyclerview_banner
            is FoodCategoryList -> R.layout.home_recyclerview_foodcategories
            is ActiveVouchers -> R.layout.home_recyclerview_activevouchers
            is OfferCollectionList -> R.layout.home_recyclerview_collections
            is RestaurantCollection -> R.layout.home_recyclerview_restaurant
        }
    }
}