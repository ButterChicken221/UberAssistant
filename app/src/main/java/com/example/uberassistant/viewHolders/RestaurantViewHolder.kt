package com.example.uberassistant.viewHolders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uberassistant.databinding.RestaurantItemViewBinding
import com.example.uberassistant.models.Restaurant

class RestaurantViewHolder(private val mBinding: RestaurantItemViewBinding): RecyclerView.ViewHolder(mBinding.root) {

    fun bindData(data: Restaurant, context: Context) {
        mBinding.restaurantName.text = data.name
        mBinding.restaurantRating.text = data.rating.toString()
        Glide.with(context).load(data.imageUrl).into(mBinding.restaurantImage)
    }
}