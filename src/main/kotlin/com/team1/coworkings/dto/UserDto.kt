package com.team1.coworkings.dto

import jakarta.persistence.Column

class UserDto(
    val id: Long = 0,
    val login: String,
    val email: String,
    val name: String,
    val role: Long = 0
)