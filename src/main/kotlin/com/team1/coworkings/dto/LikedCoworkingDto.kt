package com.team1.coworkings.dto

import java.util.*

data class LikedCoworkingDto(
    var id: Long = 0,
    var likeDate: Date,
    var coworking: Long,
    var user: Long
)
