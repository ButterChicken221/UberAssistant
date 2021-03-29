package com.example.uberassistant.models

data class Ride(
    var source: Location,
    val destination: Location,
    val fare: Float,
    val startTime: String,
    val endTime: String,
    val cabTypeCode: Int,
    val paymentInfo: PaymentInfo,
    var sourceString: String = "",
    var destinationString: String = ""
)

data class PaymentInfo(
    val type: Int,
    val account: String
)

data class Location(
    val latitude: Double,
    val longitude: Double
)