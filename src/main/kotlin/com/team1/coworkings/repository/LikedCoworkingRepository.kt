package com.team1.coworkings.repository

import com.team1.coworkings.entity.LikedCoworking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikedCoworkingRepository : JpaRepository<LikedCoworking, Long> {
}