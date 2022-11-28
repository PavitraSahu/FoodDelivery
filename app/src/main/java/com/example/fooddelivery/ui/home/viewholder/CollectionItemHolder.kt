package com.example.fooddelivery.ui.home.viewholder

import android.graphics.Color
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.OfferCollection
import com.example.fooddelivery.databinding.CollectionListItemBinding

class CollectionItemHolder(private val binding: CollectionListItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(collection: OfferCollection){
        binding.textview.text = collection.name
        val textColor:String = "#${collection.textcolor}"
        binding.textview.setTextColor(Color.parseColor(textColor));

        val media = collection.image
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