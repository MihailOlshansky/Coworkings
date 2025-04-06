package com.team1.coworkings.dto

data class CoworkingInventoryDto(
    var id: Long = 0,
    var amount: Int = 0,
    var coworking: Long,
    var inventory: Long
)
