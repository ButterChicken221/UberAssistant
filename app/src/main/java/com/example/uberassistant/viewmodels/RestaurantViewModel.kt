package com.example.uberassistant.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.uberassistant.models.Restaurant
import com.example.uberassistant.network.RetrofitClientInstance.retrofitInstance
import com.example.uberassistant.network.services.RestaurantService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestaurantViewModel(application: Application): AndroidViewModel(application) {

    private val service: RestaurantService = retrofitInstance!!.create(RestaurantService::class.java)

    fun getRestaurants(): MutableLiveData<List<Restaurant>?> {
        val data = MutableLiveData<List<Restaurant>?>()
        val call: Call<List<Restaurant>> = service.getRestaurants()
        call.enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable?) {
                data.postValue(null)
            }
        })
        return data
    }
}