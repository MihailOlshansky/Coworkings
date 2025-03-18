package com.team1.coworkings.dto

import com.fasterxml.jackson.annotation.JsonProperty

class UserRegisterDto(
    @JsonProperty("login")
    val login: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("password")
    val password: String
) {
}