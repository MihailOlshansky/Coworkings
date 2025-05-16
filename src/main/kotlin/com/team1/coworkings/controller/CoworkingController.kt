package com.team1.coworkings.controller

import com.team1.coworkings.base.BaseController
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.CoworkingDto
import com.team1.coworkings.dto.CoworkingFilter
import com.team1.coworkings.entity.Coworking
import com.team1.coworkings.mappers.CoworkingMapper
import com.team1.coworkings.service.CoworkingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("coworking/")
class CoworkingController @Autowired constructor(
    private val service: CoworkingService,
    private val mapper: CoworkingMapper
) : BaseController<Coworking, CoworkingDto> {
    override fun getService(): BaseService<Coworking> {
        return this.service
    }

    override fun getMapper(): BaseMapper<Coworking, CoworkingDto> {
        return this.mapper
    }

    @PostMapping("create")
    fun createCoworking(@RequestBody coworkingDto: CoworkingDto) {
        service.create(mapper.dtoToEntity(coworkingDto))
    }

    @PostMapping("find-with-filters")
    fun findWithFilters(@RequestBody coworkingFilter: CoworkingFilter): List<CoworkingDto> {
        return mapper.entityToDto(service.findWithFilter(coworkingFilter))
    }
}