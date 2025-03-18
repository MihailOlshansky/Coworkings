package com.team1.coworkings.repository

import com.team1.coworkings.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByCode(code: String): Role?;
}