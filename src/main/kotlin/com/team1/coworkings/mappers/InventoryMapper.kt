package com.team1.coworkings.mappers

import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.dto.InventoryDto
import com.team1.coworkings.entity.Inventory
import com.team1.coworkings.service.CoworkingInventoryService
import com.team1.coworkings.service.InventoryService
import com.team1.coworkings.utils.CommonUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InventoryMapper @Autowired constructor(
    private val coworkingInventoryService: CoworkingInventoryService
) : BaseMapper<Inventory, InventoryDto> {
    override fun entityToDto(entity: Inventory): InventoryDto {
        return InventoryDto(
            entity.id,
            entity.label,
            entity.description,
            CommonUtils.getIdsList(entity.coworkingInventories)
        )
    }

    override fun dtoToEntity(dto: InventoryDto): Inventory {
        return Inventory(
            dto.id,
            dto.label,
            dto.description,
            coworkingInventoryService.findAllById(dto.coworkingInventories)
        )
    }
}