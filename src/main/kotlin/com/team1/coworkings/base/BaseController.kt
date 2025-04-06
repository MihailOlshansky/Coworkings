package com.team1.coworkings.base

import com.team1.coworkings.dto.LikedCoworkingDto
import com.team1.coworkings.entity.LikedCoworking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface BaseController<E : Any, Dto> {
    fun getService(): BaseService<E>
    fun getMapper(): BaseMapper<E, Dto>

    @GetMapping("find/")
    fun findAll(): List<Dto> {
        return this.getMapper().entityToDto(this.getService().findAll())
    }

    @GetMapping("find/{id}")
    fun findById(@PathVariable(value = "id") id: Long): Dto? {
        return this.getMapper().entityToDto(this.getService().findByIdNonNull(id))
    }
}
