package com.example.uberassistant.models

data class Ride(
    val source: Location,
    val destination: Location,
    val fare: Float,
    val startTime: Long,
    val endTime: Long,
    val cabType: Int,
    val paymentInfo: PaymentInfo
)

data class PaymentInfo(
    val type: Int,
    val account: String
)

data class Location(
    val lat: Double,
    val long: Double
)