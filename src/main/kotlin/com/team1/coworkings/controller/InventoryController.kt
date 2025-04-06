package com.team1.coworkings.controller

import com.team1.coworkings.base.BaseController
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.InventoryDto
import com.team1.coworkings.entity.Inventory
import com.team1.coworkings.mappers.InventoryMapper
import com.team1.coworkings.service.InventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("inventory/")
class InventoryController @Autowired constructor(
    private val service: InventoryService,
    private val mapper: InventoryMapper
) : BaseController<Inventory, InventoryDto> {
    override fun getService(): BaseService<Inventory> {
        return this.service
    }

    override fun getMapper(): BaseMapper<Inventory, InventoryDto> {
        return this.mapper
    }
}