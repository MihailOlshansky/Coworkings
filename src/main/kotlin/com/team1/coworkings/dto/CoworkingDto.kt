package com.team1.coworkings.dto

data class CoworkingDto(
    var id: Long = 0,
    var label: String,
    var description: String,
    var address: String,
    var capacity: Int,
    var openFrom: String,
    var openTo: String,
    var bookings: List<Long> = listOf(),
    var likedCoworkings: List<Long> = listOf(),
    var coworkingInventories: List<Long> = listOf()
)
