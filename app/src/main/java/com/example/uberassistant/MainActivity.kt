package com.example.uberassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uberassistant.adapters.RestaurantAdapter
import com.example.uberassistant.databinding.ActivityMainBinding
import com.example.uberassistant.models.Restaurant
import com.example.uberassistant.viewmodels.RestaurantViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private var restaurantList = ArrayList<Restaurant>()
    private lateinit var mAdapter: RestaurantAdapter
    private lateinit var mViewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application).create(RestaurantViewModel::class.java)

        mViewModel.getRestaurants().observe(this, Observer {
            it?.let {
                restaurantList.addAll(it)
                setupRestaurantRv()
            }
        })
    }

    private fun setupRestaurantRv() {
        mAdapter = RestaurantAdapter(restaurantList, this)
        mBinding.restaurantRv.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

}