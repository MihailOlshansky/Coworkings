package com.team1.coworkings.repository

import com.team1.coworkings.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByLogin(login: String): User
}