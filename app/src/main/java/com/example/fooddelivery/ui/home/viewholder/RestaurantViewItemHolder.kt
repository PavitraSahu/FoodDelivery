package com.example.fooddelivery.ui.home.viewholder

import android.graphics.Color
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.OfferCollection
import com.example.fooddelivery.data.model.Restaurant
import com.example.fooddelivery.data.model.RestaurantCollection
import com.example.fooddelivery.databinding.CollectionListItemBinding
import com.example.fooddelivery.databinding.RestaurantsListItemBinding

class RestaurantViewItemHolder(private val binding: RestaurantsListItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(restaurant: Restaurant){
        binding.restaurant = restaurant

//        val offers = restaurant.offers
//        if(offers!=null && offers.size>0){
//            if(offers.get(0)!=null){
//                val textColor:String = "#${offers.get(0).textcolor}"
//                binding.offertvOne.setTextColor(Color.parseColor(textColor));
//                val backgroundColor:String ="#${offers.get(0).background}"
//                binding.offertvOne.setBackgroundColor(Color.parseColor(backgroundColor))
//            }
//            if(offers.get(1)!=null){
//                if(offers.get(1).textcolor!=null) {
//                    val textColor: String = "#${offers.get(1).textcolor}"
//                    binding.offertvTwo.setTextColor(Color.parseColor(textColor));
//                }
//                if(offers.get(1).background!=null) {
//                    val backgroundColor: String = "#${offers.get(1).background}"
//                    binding.offertvTwo.setBackgroundColor(Color.parseColor(backgroundColor))
//                }
//            }
//        }

        val media = restaurant.image_url
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