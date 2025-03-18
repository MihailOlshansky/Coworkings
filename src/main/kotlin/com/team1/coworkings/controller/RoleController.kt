package com.team1.coworkings.controller

import com.team1.coworkings.constants.RoleCodes
import com.team1.coworkings.entity.Role
import com.team1.coworkings.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("role/")
class RoleController @Autowired constructor(
    private val service: RoleService
){
    @PostMapping("init")
    fun initRoles() {
        RoleCodes.entries.forEach {
            code -> service.save(Role(code = code.toString()))
        }
    }
}