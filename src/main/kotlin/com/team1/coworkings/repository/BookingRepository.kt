package com.team1.coworkings.repository

import com.team1.coworkings.entity.Booking
import com.team1.coworkings.entity.Coworking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : JpaRepository<Booking, Long> {
    fun findAllByCoworkingId(coworking: Long): List<Booking>
}