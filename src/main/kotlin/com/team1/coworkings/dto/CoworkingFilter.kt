package com.team1.coworkings.dto

data class CoworkingFilter (
    var labelMask: String?,
    var address: String?,
    var capacity: Int?,
    var openFrom: String?,
    var openTo: String?,
    var inventories: List<Long>?
)
