package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.constants.RoleCodes
import com.team1.coworkings.entity.Role
import com.team1.coworkings.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class RoleService @Autowired constructor(
    private val repository: RoleRepository
): BaseService<Role> {
    override fun getRepository(): JpaRepository<Role, Long> {
        return repository
    }

    fun findByCode(code: RoleCodes): Role {

        val role: Role? = this.repository.findByCode(code.toString())
        if (role == null) {
            if (role == null) {
                throw Exception("Роль с кодом " + code + " не найдена")
            }
        }

        return role
    }
}