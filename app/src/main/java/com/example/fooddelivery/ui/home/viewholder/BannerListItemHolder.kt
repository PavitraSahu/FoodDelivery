package com.example.fooddelivery.ui.home.viewholder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.Banner
import com.example.fooddelivery.data.model.home_recyclerview_model.HomeRecyclcerViewItem
import com.example.fooddelivery.databinding.BannerListItemBinding

class BannerListItemHolder(private val binding: BannerListItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(banner: Banner){
        val media = banner.image_url
        val imageView: ImageView = binding.imageView
        if (media !== null) {
            Glide.with(binding.root.context)
                .load(media)
                .into(imageView)
        } else {
            imageView.setImageResource(R.drawable.no_food)
        }
    }
}