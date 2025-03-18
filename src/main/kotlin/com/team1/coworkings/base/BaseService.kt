package com.team1.coworkings.base

import jakarta.persistence.Entity
import org.springframework.data.jpa.repository.JpaRepository

interface BaseService<E : Any> {
    fun getRepository(): JpaRepository<E, Long>

    fun findAll(): List<E> {
        return this.getRepository().findAll()
    }

    fun findById(id: Long): E? {
        return this.getRepository().findById(id).orElse(null)
    }

    fun save(entity: E): E {
        return this.getRepository().save(entity)
    }
}