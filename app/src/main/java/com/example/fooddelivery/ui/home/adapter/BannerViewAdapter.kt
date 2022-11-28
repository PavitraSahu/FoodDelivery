package com.example.fooddelivery.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.data.model.Banner
import com.example.fooddelivery.databinding.BannerListItemBinding
import com.example.fooddelivery.databinding.HomeRecyclerviewBannerBinding
import com.example.fooddelivery.ui.home.viewholder.BannerListItemHolder
import com.example.fooddelivery.ui.home.viewholder.HomeRecyclerviewHolder

class BannerViewAdapter() : RecyclerView.Adapter<BannerListItemHolder>() {
    var bannerItems = ArrayList<Banner>()

    fun addBannerItems(list: ArrayList<Banner>) {
        bannerItems = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerListItemHolder {
        return BannerListItemHolder(
            BannerListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BannerListItemHolder, position: Int) {
        holder.bind(bannerItems[position])
    }

    override fun getItemCount(): Int {
        return bannerItems.size
    }

}