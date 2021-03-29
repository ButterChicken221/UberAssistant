package com.example.uberassistant.network.services

import com.example.uberassistant.models.Ride
import com.example.uberassistant.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UberAssistantDataService {
    @GET("/ride/history")
    fun getRideHistory(
        @Query("userId") userId: Int,
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 100
    ): Call<List<Ride>>

    @GET("/ride/suggest")
    fun getSuggestedRide(
        @Query("userId") userId: Int,
        @Query("currLat") currLat: Double,
        @Query("currLong") currLong: Double,
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 100
    ): Call<Ride>

    @GET("/users")
    fun getUsers(): Call<List<User>>
}