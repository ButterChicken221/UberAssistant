package com.example.uberassistant.network.services

import com.example.uberassistant.models.Restaurant
import com.example.uberassistant.models.RestaurantDetailInfo
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {
    @GET("")
    fun getRestaurants(): Call<List<Restaurant>>

    @GET("")
    fun getRestaurantInfo(id: String): Call<RestaurantDetailInfo>
}