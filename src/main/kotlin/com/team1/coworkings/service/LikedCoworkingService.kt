package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.LikedCoworking
import com.team1.coworkings.repository.LikedCoworkingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class LikedCoworkingService @Autowired constructor(
    private val repository: LikedCoworkingRepository
): BaseService<LikedCoworking> {
    override fun getRepository(): JpaRepository<LikedCoworking, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Избранное"
    }
}