package com.example.fooddelivery.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.data.model.Banner
import com.example.fooddelivery.data.model.OfferCollection
import com.example.fooddelivery.databinding.BannerListItemBinding
import com.example.fooddelivery.databinding.CollectionListItemBinding
import com.example.fooddelivery.ui.home.viewholder.BannerListItemHolder
import com.example.fooddelivery.ui.home.viewholder.CollectionItemHolder

class CollectionViewAdapter() : RecyclerView.Adapter<CollectionItemHolder>() {
    var collections = ArrayList<OfferCollection>()

    fun addCollectionItems(list: ArrayList<OfferCollection>) {
        collections = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionItemHolder {
        return CollectionItemHolder(
            CollectionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CollectionItemHolder, position: Int) {
        holder.bind(collections[position])
    }

    override fun getItemCount(): Int {
        return collections.size
    }

}