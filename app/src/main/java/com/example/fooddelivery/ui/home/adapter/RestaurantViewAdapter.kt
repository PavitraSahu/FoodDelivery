package com.example.fooddelivery.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.data.model.OfferCollection
import com.example.fooddelivery.data.model.Restaurant
import com.example.fooddelivery.databinding.CollectionListItemBinding
import com.example.fooddelivery.databinding.RestaurantsListItemBinding
import com.example.fooddelivery.ui.home.viewholder.CollectionItemHolder
import com.example.fooddelivery.ui.home.viewholder.RestaurantViewItemHolder

class RestaurantViewAdapter() : RecyclerView.Adapter<RestaurantViewItemHolder>() {
    var restaurantList= ArrayList<Restaurant>()

    fun addRestaurants(list: ArrayList<Restaurant>) {
        restaurantList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewItemHolder {
        val binding = RestaurantsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewItemHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewItemHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

}