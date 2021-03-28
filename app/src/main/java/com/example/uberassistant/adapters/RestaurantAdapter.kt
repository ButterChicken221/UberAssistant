package com.example.uberassistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uberassistant.databinding.RestaurantItemViewBinding
import com.example.uberassistant.models.Restaurant
import com.example.uberassistant.viewHolders.RestaurantViewHolder

class RestaurantAdapter(private var mList: List<Restaurant>, private var mContext: Context): RecyclerView.Adapter<RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(RestaurantItemViewBinding.inflate(LayoutInflater.from(mContext), parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bindData(mList[position], mContext)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}