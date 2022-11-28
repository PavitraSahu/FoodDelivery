package com.example.fooddelivery.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.data.model.Banner
import com.example.fooddelivery.data.model.FoodCategory
import com.example.fooddelivery.databinding.BannerListItemBinding
import com.example.fooddelivery.databinding.FoodCategoryItemBinding
import com.example.fooddelivery.ui.home.viewholder.BannerListItemHolder
import com.example.fooddelivery.ui.home.viewholder.FoodCategoryItemHolder

class FoodCategoryViewAdapter() : RecyclerView.Adapter<FoodCategoryItemHolder>() {
    var foodCategories = ArrayList<FoodCategory>()

    fun addFoodCategoryItems(list: ArrayList<FoodCategory>) {
        foodCategories = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoryItemHolder {
        return FoodCategoryItemHolder(
            FoodCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FoodCategoryItemHolder, position: Int) {
        holder.bind(foodCategories[position])
    }

    override fun getItemCount(): Int {
        return foodCategories.size
    }

}