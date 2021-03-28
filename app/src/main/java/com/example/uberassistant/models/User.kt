package com.example.uberassistant.models

data class User(
    val id: Int,
    val name: String,
    val email: String
)

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

enum class PaymentType(value: Int) {
    GPAY(1),
    PAYTM(2),
    DEBIT_CARD(3),
    CREDIT_CARD(4)
}

enum class RideType(value: Int) {
    GO(1),
    BLACK(2),
    SEDAN(3),
    PRIME(4),
    MOTO(5),
}

data class Location(
    val lat: Long,
    val long: Long
)
