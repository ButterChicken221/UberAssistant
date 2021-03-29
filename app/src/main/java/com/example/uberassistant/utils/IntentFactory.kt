package com.example.uberassistant.utils

import android.content.Context
import android.content.Intent
import com.example.uberassistant.OneTapRideBookingActivity
import com.example.uberassistant.models.Ride
import com.google.gson.Gson

object IntentFactory {
    fun getOneTapRideIntent(context: Context, ride: Ride) =
        Intent(context, OneTapRideBookingActivity::class.java).apply {
            putExtra("ride", Gson().toJson(ride).toString())
        }
}