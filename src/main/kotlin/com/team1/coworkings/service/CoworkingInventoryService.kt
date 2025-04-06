package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.CoworkingInventory
import com.team1.coworkings.repository.CoworkingInventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CoworkingInventoryService @Autowired constructor(
    private val repository: CoworkingInventoryRepository
): BaseService<CoworkingInventory> {
    override fun getRepository(): JpaRepository<CoworkingInventory, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Оборудование коворкинга"
    }
}