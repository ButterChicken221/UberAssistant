package com.example.uberassistant.models

data class Restaurant(
    val id: String,
    val name: String,
    val rating: String,
    val openTime: Long = 0,
    val closingTime: Long = 0,
    val cuisines: List<String>? = null,
    val costForOne: Int = 0,
    val slotsAvailable: Int = 0,
    val imageUrl: String = "",
)
