package com.example.uberassistant.models

data class Restaurant(
    val id: String,
    val name: String,
    val rating: Float,
    val openTime: Long,
    val closingTime: Long,
    val cuisines: List<String>,
    val costForOne: Int,
    val slotsAvailable: Int
)
