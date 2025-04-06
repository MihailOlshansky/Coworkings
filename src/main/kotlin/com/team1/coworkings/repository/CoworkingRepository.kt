package com.team1.coworkings.repository

import com.team1.coworkings.entity.Coworking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoworkingRepository : JpaRepository<Coworking, Long> {
}