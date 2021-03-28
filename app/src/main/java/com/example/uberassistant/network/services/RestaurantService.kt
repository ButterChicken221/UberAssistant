package com.example.uberassistant.network.services

import com.example.uberassistant.models.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {
    @GET("")
    fun getRestaurants(): Call<List<Restaurant>>
}