package com.team1.coworkings.base

import com.team1.coworkings.exception.EntityNotFoundException
import com.team1.coworkings.exception.EntitySaveError
import jakarta.persistence.Entity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.util.CollectionUtils

interface BaseService<E : Any> {
    fun getRepository(): JpaRepository<E, Long>
    fun getEntityName(): String

    fun findAll(): List<E> {
        return this.getRepository().findAll()
    }

    fun findById(id: Long): E? {
        return this.getRepository().findById(id).orElse(null)
    }

    fun findByIdNonNull(id: Long): E {
        return this.getRepository().findById(id).orElseThrow {
            EntityNotFoundException(getEntityName())
        }
    }

    fun findAllById(ids: Collection<Long>): List<E> {
        if (CollectionUtils.isEmpty(ids)) {
            return listOf()
        }
        return this.getRepository().findAllById(ids)
    }

    fun deleteById(id: Long) {
        this.getRepository().deleteById(id)
    }

    fun delete(entity: E) {
        this.getRepository().delete(entity)
    }

    fun update(id: Long, entity: E): E {
        if (this.getRepository().existsById(id)) {
            return this.save(entity)
        } else {
            throw EntityNotFoundException(getEntityName())
        }
    }

    fun save(entity: E): E {
        try {
            return this.getRepository().save(entity)
        } catch (e: Exception) {
            throw EntitySaveError(getEntityName(), e)
        }
    }
}