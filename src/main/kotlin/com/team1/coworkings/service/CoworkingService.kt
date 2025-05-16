package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.CoworkingFilter
import com.team1.coworkings.entity.Coworking
import com.team1.coworkings.exception.LogicalException
import com.team1.coworkings.repository.CoworkingRepository
import com.team1.coworkings.utils.CommonUtils
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.util.stream.Collectors

@Service
class CoworkingService @Autowired constructor(
    private val repository: CoworkingRepository
) : BaseService<Coworking> {
    override fun getRepository(): JpaRepository<Coworking, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Коворкинг"
    }

    fun create(coworking: Coworking) {
        if (!CommonUtils.checkTimeFormat(coworking.openFrom)
            || !CommonUtils.checkTimeFormat(coworking.openTo)
        ) {
            throw LogicalException("Неверный формат времени работы коворкинга")
        }

        coworking.openFrom = CommonUtils.correctDate(coworking.openFrom)
        coworking.openTo = CommonUtils.correctDate(coworking.openTo)

        this.save(coworking)
    }

    fun findWithFilter(coworkingFilter: CoworkingFilter): List<Coworking> {
        val labelMask: String? =
            if (StringUtils.isBlank(coworkingFilter.labelMask)) null
            else "%${coworkingFilter.labelMask}%"

        val coworkings: List<Coworking> = repository.findByFilters(
            labelMask,
            coworkingFilter.address,
            coworkingFilter.capacity,
            coworkingFilter.openFrom,
            coworkingFilter.openTo
        )

        if (CollectionUtils.isEmpty(coworkingFilter.inventories)) {
            return coworkings
        } else {
            return coworkings.stream()
                .filter {
                    it.coworkingInventories.stream()
                        .map { it.inventory.id }
                        .collect(Collectors.toList())
                        .containsAll(coworkingFilter.inventories!!)
                }
                .collect(Collectors.toList())
        }
    }
}