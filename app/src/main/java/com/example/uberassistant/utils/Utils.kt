package com.example.uberassistant.utils

import android.app.NotificationManager
import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat

object Utils {

    fun showShortToast(msg: String, context: Context) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(msg: String, context: Context) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}