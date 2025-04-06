package com.team1.coworkings.controller

import com.team1.coworkings.base.BaseController
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.CoworkingInventoryDto
import com.team1.coworkings.entity.CoworkingInventory
import com.team1.coworkings.mappers.CoworkingInventoryMapper
import com.team1.coworkings.service.CoworkingInventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("coworkingInventory/")
class CoworkingInventoryController @Autowired constructor(
    private val service: CoworkingInventoryService,
    private val mapper: CoworkingInventoryMapper
) : BaseController<CoworkingInventory, CoworkingInventoryDto> {
    override fun getService(): BaseService<CoworkingInventory> {
        return this.service
    }

    override fun getMapper(): BaseMapper<CoworkingInventory, CoworkingInventoryDto> {
        return this.mapper
    }
}