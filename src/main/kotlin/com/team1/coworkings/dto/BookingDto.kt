package com.team1.coworkings.dto

import java.util.Date

data class BookingDto(
    var id: Long = 0,
    var dateFrom: Date,
    var dateTo: Date,
    var personsAmount: Int = 0,
    var coworking: Long,
    var user: Long
)
