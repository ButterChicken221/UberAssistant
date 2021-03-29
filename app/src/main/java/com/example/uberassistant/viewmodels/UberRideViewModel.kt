package com.example.uberassistant.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uberassistant.models.Ride
import com.example.uberassistant.models.User
import com.example.uberassistant.network.RetrofitClientInstance
import com.example.uberassistant.network.services.UberAssistantDataService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UberRideViewModel: ViewModel() {

    private val service: UberAssistantDataService = RetrofitClientInstance.retrofitInstance!!.create(UberAssistantDataService::class.java)

    fun getSuggestedRide(currLat: Double, currLong: Double): MutableLiveData<Ride?> {
        val data = MutableLiveData<Ride?>()
        val call: Call<Ride> = service.getSuggestedRide(1, currLat, currLong)
        call.enqueue(object : Callback<Ride> {
            override fun onResponse(call: Call<Ride>, response: Response<Ride>) {
                data.postValue(response.body())
            }
            override fun onFailure(call: Call<Ride>, t: Throwable?) {
                data.postValue(null)
            }
        })
        return data
    }

    fun getUsers() {
        val data = MutableLiveData<List<User>>()
        val call: Call<List<User>> = service.getUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                Log.d("shakti", "onResponse: $response")
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable?) {
                data.postValue(null)
            }
        })
    }
}