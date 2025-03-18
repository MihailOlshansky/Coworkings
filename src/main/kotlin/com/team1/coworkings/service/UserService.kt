package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.User
import com.team1.coworkings.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val repository: UserRepository
) : BaseService<User> {
    override fun getRepository(): JpaRepository<User, Long> {
        return this.repository;
    }
}