package com.example.uberassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uberassistant.databinding.ActivityRestaurantDetailsBinding

class RestaurantDetailsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRestaurantDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRestaurantDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


    }
}