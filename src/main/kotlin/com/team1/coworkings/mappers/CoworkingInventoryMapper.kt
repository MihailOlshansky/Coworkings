package com.team1.coworkings.mappers

import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.dto.CoworkingInventoryDto
import com.team1.coworkings.entity.CoworkingInventory
import com.team1.coworkings.service.CoworkingInventoryService
import com.team1.coworkings.service.CoworkingService
import com.team1.coworkings.service.InventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CoworkingInventoryMapper @Autowired constructor(
    private val coworkingService: CoworkingService,
    private val inventoryService: InventoryService
) : BaseMapper<CoworkingInventory, CoworkingInventoryDto> {
    override fun entityToDto(entity: CoworkingInventory): CoworkingInventoryDto {
        return CoworkingInventoryDto(
            entity.id,
            entity.amount,
            entity.coworking.id,
            entity.inventory.id
        )
    }

    override fun dtoToEntity(dto: CoworkingInventoryDto): CoworkingInventory {
        val coworking = coworkingService.findByIdNonNull(dto.coworking)
        val inventory = inventoryService.findByIdNonNull(dto.inventory)

        return CoworkingInventory(
            dto.id,
            dto.amount,
            coworking,
            inventory
        )
    }
}