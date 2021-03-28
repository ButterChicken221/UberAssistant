package com.example.uberassistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uberassistant.databinding.ActivityOneTapRideBookingBinding
import com.example.uberassistant.utils.Constants
import java.math.BigDecimal
import java.text.Format
import java.text.NumberFormat
import java.util.*

class OneTapRideBookingActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityOneTapRideBookingBinding
    private var source = ""
    private var destination = ""
    private var price = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityOneTapRideBookingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setData()
        if(!isValidData()) {
            finish()
            return
        }
        updateUI()
    }

    private fun isValidData(): Boolean {
        return source.isNotEmpty() && destination.isNotEmpty() && price > 0f
    }

    private fun setData() {
        intent.extras?.apply {
            source = getString(Constants.SOURCE) ?: ""
            destination = getString(Constants.DESTINATION) ?: ""
            price = getFloat(Constants.PRICE)
        }
    }

    private fun getIndianRupee(value: String?): String? {
        val format: Format = NumberFormat.getCurrencyInstance(Locale("en", "in"))
        return format.format(BigDecimal(value))
    }

    private fun updateUI() {
        mBinding.source.text = source
        mBinding.destination.text = destination
        mBinding.price.text = getIndianRupee(price.toString())
    }

}