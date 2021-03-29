package com.example.uberassistant

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.uberassistant.databinding.ActivityMainBinding
import com.example.uberassistant.models.Location
import com.example.uberassistant.models.PaymentInfo
import com.example.uberassistant.models.Ride
import com.example.uberassistant.utils.CalendarContentResolver
import com.example.uberassistant.utils.IntentFactory
import com.example.uberassistant.utils.Utils
import com.example.uberassistant.viewmodels.UberRideViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.firebase.iid.FirebaseInstanceId
import kotlin.collections.ArrayList
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val locations = ArrayList<Address>()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var destination: Address
    private lateinit var source: Address
    private lateinit var mViewModel: UberRideViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application).create(UberRideViewModel::class.java)
        mViewModel.getUsers()
        getPermissions()
        fusedLocationClient = FusedLocationProviderClient(this)
        setDestination()
        mViewModel.getSuggestedRide().observe(this, Observer {
            it?.let {
                startActivity(
                    IntentFactory.getOneTapRideIntent(
                        this,
                        it
                    )
                )
            }
        })
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.d("shakti", "onCreate: ${it.token}")
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
            permissions = permissions && ContextCompat.checkSelfPermission(
                this,
                p
            ) == PackageManager.PERMISSION_GRANTED
        }
        if (!permissions) ActivityCompat.requestPermissions(this, permissionsId, callbackId)
    }

    @SuppressLint("MissingPermission")
    private fun setSource() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            getPermissions()
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it == null) {
                Utils.showLongToast("location not found", this)
            } else {
                startActivity(
                    IntentFactory.getOneTapRideIntent(
                        this,
                        Ride(
                            Location(it.latitude, it.longitude),
                            Location(destination.latitude, destination.longitude),
                            getPrice(),
                            System.currentTimeMillis(),
                            System.currentTimeMillis() + 30*60*1000,
                            0,
                            PaymentInfo(0,"123456789")
                        )
                    )
                )
            }
        }
    }

    private fun getPrice() = (Random.nextFloat() * 100 + 100).roundToInt().toFloat()


    private fun setDestination() {
        val resolver = CalendarContentResolver(this)
        resolver.getEvents().forEach {
            val location = Geocoder(this).getFromLocationName(it, 1)
            if (location.size > 0)
                locations.add(location[0])
        }
        if (locations.size > 0) {
            destination = locations[0]
            setSource()
        } else {
            Utils.showLongToast("no destination found", this)
        }
    }

}