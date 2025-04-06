package com.team1.coworkings.base

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

interface BaseEntity {
    fun getPk() : Long
}