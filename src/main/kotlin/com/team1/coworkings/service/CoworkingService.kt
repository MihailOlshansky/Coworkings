package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.Coworking
import com.team1.coworkings.exception.EntityNotFoundException
import com.team1.coworkings.exception.LogicalException
import com.team1.coworkings.repository.CoworkingRepository
import com.team1.coworkings.utils.events.CoworkingWorkingHoursUpdatedEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CoworkingService @Autowired constructor(
    private val repository: CoworkingRepository,
    private val eventPublisher: ApplicationEventPublisher
): BaseService<Coworking> {
    private val TIME_REGEX: Regex = Regex("""(([0-1]\d)|\d|2[0-3]):(([0-5]\d)|\d)""")

    override fun getRepository(): JpaRepository<Coworking, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Коворкинг"
    }

    override fun update(id: Long, entity: Coworking): Coworking {
        if (!isValidTime(entity.openFrom, entity.openTo)) {
            throw LogicalException("Неверный формат времени работы коворкинга")
        }
        val currentEntity = findById(id) ?: throw EntityNotFoundException(getEntityName())
        val newEntity = super.update(id, entity)
        if (currentEntity != null && (currentEntity.openFrom != newEntity.openFrom || currentEntity.openTo != newEntity.openTo)) {
            eventPublisher.publishEvent(
                CoworkingWorkingHoursUpdatedEvent(
                    id,
                    currentEntity.openFrom,
                    currentEntity.openTo
                )
            )
        }
        return newEntity
    }

    fun create(coworking: Coworking) {
        if (!isValidTime(coworking.openFrom, coworking.openTo)) {
            throw LogicalException("Неверный формат времени работы коворкинга")
        }

        this.save(coworking)
    }

    private fun isValidTime(from: String, to: String): Boolean {
        return !(!TIME_REGEX.matches(from) || !TIME_REGEX.matches(to))
    }
}