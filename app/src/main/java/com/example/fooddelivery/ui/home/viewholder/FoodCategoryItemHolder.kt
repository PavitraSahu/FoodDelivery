package com.example.fooddelivery.ui.home.viewholder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.Banner
import com.example.fooddelivery.data.model.FoodCategory
import com.example.fooddelivery.databinding.BannerListItemBinding
import com.example.fooddelivery.databinding.FoodCategoryItemBinding
import com.makeramen.roundedimageview.RoundedImageView

class FoodCategoryItemHolder(private val binding: FoodCategoryItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(foodCategory: FoodCategory){
        binding.textview.text = foodCategory.name
//        binding.textview.setTextColor(binding.root.resources.getColor(androidx.constraintlayout.widget.R.color.material_grey_600, null));

        val media = foodCategory.icon
        val imageView: RoundedImageView = binding.imageView
        if (media !== null) {
            Glide.with(binding.root.context)
                .load(media)
                .into(imageView)
        } else {
            imageView.setImageResource(R.drawable.no_food)
        }
    }
}