package com.example.uberassistant.utils

import android.content.Context
import android.location.Geocoder
import android.widget.Toast
import com.example.uberassistant.models.Location
import java.lang.Exception

object Utils {

    fun showShortToast(msg: String, context: Context) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(msg: String, context: Context) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun getAddress(context: Context, location: Location?): String {
        var address = ""
        if(location?.lat != null) {
            try {
                address = Geocoder(context).getFromLocation(location.lat, location.long, 1)[0].getAddressLine(0)
            }
            catch (ex: Exception) {

            }
        }
        return address
    }

}