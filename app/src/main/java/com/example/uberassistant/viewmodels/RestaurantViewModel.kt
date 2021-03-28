package com.example.uberassistant.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uberassistant.models.Restaurant
import com.example.uberassistant.network.RetrofitClientInstance.retrofitInstance
import com.example.uberassistant.network.services.RestaurantService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestaurantViewModel(): ViewModel() {

    //private val service: RestaurantService = retrofitInstance!!.create(RestaurantService::class.java)

    fun getRestaurants(): MutableLiveData<List<Restaurant>?> {
        val data = MutableLiveData<List<Restaurant>?>()
        /*val call: Call<List<Restaurant>> = service.getRestaurants()
        call.enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable?) {
                data.postValue(null)
            }
        })*/
        viewModelScope.launch {
            delay(1000)
            val list = listOf<Restaurant>(
                Restaurant("1", "Hauz Khas Social", rating = "4.3", imageUrl = "https://b.zmtcdn.com/data/pictures/7/18037817/235a118e0c275deae64db9a2a4b3d6a2_featured_v2.png"),
                Restaurant("2", "Qubitos - The Terrace Cafe", rating = "4.5", imageUrl = "https://b.zmtcdn.com/data/pictures/2/308322/cf86dbd8b8ca4d40682c7713f112cc07_featured_v2.jpg"),
                Restaurant("3", "Hauz Khas Social", rating = "4.3", imageUrl = "https://b.zmtcdn.com/data/pictures/7/18037817/235a118e0c275deae64db9a2a4b3d6a2_featured_v2.png"),
                Restaurant("4", "Hauz Khas Social", rating = "4.3", imageUrl = "https://b.zmtcdn.com/data/pictures/7/18037817/235a118e0c275deae64db9a2a4b3d6a2_featured_v2.png")
            )
            data.postValue(list)
        }

        return data
    }

    fun getRestaurantInfo(id: String) {

    }
}