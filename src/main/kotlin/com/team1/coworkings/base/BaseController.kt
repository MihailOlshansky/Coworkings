package com.team1.coworkings.base

import org.springframework.web.bind.annotation.GetMapping

interface BaseController<E : Any, Dto> {
    fun getService(): BaseService<E>
    fun getMapper(): BaseMapper<E, Dto>

    @GetMapping("find/")
    fun findAll(): List<Dto> {
        return this.getMapper().entityToDto(this.getService().findAll())
    }
}
