package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.Inventory
import com.team1.coworkings.repository.InventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class InventoryService @Autowired constructor(
    private val repository: InventoryRepository
): BaseService<Inventory> {
    override fun getRepository(): JpaRepository<Inventory, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Оборудование"
    }
}