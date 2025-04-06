package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.Coworking
import com.team1.coworkings.exception.LogicalException
import com.team1.coworkings.repository.CoworkingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CoworkingService @Autowired constructor(
    private val repository: CoworkingRepository
): BaseService<Coworking> {
    private val TIME_REGEX: Regex = Regex("""(([0-1]\d)|\d|2[0-3]):(([0-5]\d)|\d)""")

    override fun getRepository(): JpaRepository<Coworking, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Коворкинг"
    }

    fun create(coworking: Coworking) {
        if (!TIME_REGEX.matches(coworking.openFrom)
            || !TIME_REGEX.matches(coworking.openTo)) {
            throw LogicalException("Неверный формат времени работы коворкинга")
        }

        this.save(coworking)
    }
}