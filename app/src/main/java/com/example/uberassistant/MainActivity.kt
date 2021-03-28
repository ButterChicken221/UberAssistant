package com.example.uberassistant

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.icu.lang.UCharacter
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uberassistant.adapters.RestaurantAdapter
import com.example.uberassistant.databinding.ActivityMainBinding
import com.example.uberassistant.models.Restaurant
import com.example.uberassistant.utils.CalendarContentResolver
import com.example.uberassistant.utils.IntentFactory
import com.example.uberassistant.utils.Utils
import com.example.uberassistant.viewmodels.RestaurantViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private var restaurantList = ArrayList<Restaurant>()
    private lateinit var mAdapter: RestaurantAdapter
    private lateinit var mViewModel: RestaurantViewModel
    private val locations = ArrayList<Address>()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var destination: Address
    private lateinit var source: Address

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        getPermissions()
        fusedLocationClient = FusedLocationProviderClient(this)
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application).create(RestaurantViewModel::class.java)
        setDestination()
        setSource()
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
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun getPermissions() {
        checkPermissions(
            42,
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }

    private fun checkPermissions(callbackId: Int, vararg permissionsId: String) {
        var permissions = true
        for (p in permissionsId) {
            permissions = permissions && ContextCompat.checkSelfPermission(this, p) == PackageManager.PERMISSION_GRANTED
        }
        if (!permissions) ActivityCompat.requestPermissions(this, permissionsId, callbackId)
    }

    @SuppressLint("MissingPermission")
    private fun setSource() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            getPermissions()
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if(it == null) {
                Utils.showLongToast("location not found", this)
            }
            else {
                val location = Geocoder(this).getFromLocation(it.latitude, it.longitude, 1)
                if(location.size > 0) {
                    source = location[0]
                    if(source.getAddressLine(0)?.isNotEmpty() == true && destination.getAddressLine(0)?.isNotEmpty() == true)
                    startActivity(IntentFactory.getOneTapRideIntent(this, source.getAddressLine(0), destination.getAddressLine(0), getPrice()))
                }
                else {
                    Utils.showLongToast("no source found", this)
                }
            }
        }
    }

    private fun getPrice() = (Random.nextFloat()*100+100).roundToInt().toFloat()


    private fun setDestination() {
        val resolver = CalendarContentResolver(this)
        resolver.getEvents().forEach {
            val location = Geocoder(this).getFromLocationName(it, 1)
            if(location.size > 0)
                locations.add(location[0])
        }
        if(locations.size > 0) {
            destination = locations[0]
        }
        else {
            Utils.showLongToast("no destination found", this)
        }
    }

}