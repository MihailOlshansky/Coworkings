package com.team1.coworkings.dto


data class InventoryDto(
    var id: Long = 0,
    var label: String,
    var description: String,
    var coworkingInventories: List<Long> = listOf()
)
