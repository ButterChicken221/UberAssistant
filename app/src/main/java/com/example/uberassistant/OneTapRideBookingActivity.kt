package com.example.uberassistant

import android.content.Context
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.uberassistant.databinding.ActivityOneTapRideBookingBinding
import com.example.uberassistant.models.Location
import com.example.uberassistant.models.Ride
import com.example.uberassistant.utils.Constants
import com.example.uberassistant.utils.Utils.getAddress
import com.google.firebase.iid.FirebaseInstanceId
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.math.BigDecimal
import java.text.Format
import java.text.NumberFormat
import java.util.*

class OneTapRideBookingActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityOneTapRideBookingBinding
    private var ride: Ride? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityOneTapRideBookingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setData()
        updateUI()
    }

    private fun setData() {
        intent.extras?.apply {
            get("ride")?.let {
                ride = Gson().fromJson(it.toString(), object : TypeToken<Ride>() {}.type)
            }
        }
    }

    private fun getIndianRupee(value: String?): String? {
        val format: Format = NumberFormat.getCurrencyInstance(Locale("en", "in"))
        return format.format(BigDecimal(value))
    }

    private fun updateUI() {
        mBinding.source.text = getAddress(this, ride?.source)
        mBinding.destination.text = getAddress(this, ride?.destination)
        mBinding.price.text = getIndianRupee(ride?.fare.toString())
    }

}