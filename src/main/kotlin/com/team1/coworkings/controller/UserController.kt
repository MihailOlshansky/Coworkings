package com.team1.coworkings.controller

import com.team1.coworkings.base.BaseController
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.UserDto
import com.team1.coworkings.dto.UserRegisterDto
import com.team1.coworkings.entity.User
import com.team1.coworkings.mappers.UserMapper
import com.team1.coworkings.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user/")
class UserController @Autowired constructor(
    private val service: UserService,
    private val mapper: UserMapper
) : BaseController<User, UserDto> {
    override fun getService(): BaseService<User> {
        return this.service
    }

    override fun getMapper(): BaseMapper<User, UserDto> {
        return this.mapper
    }

    @PostMapping("register")
    fun register(@RequestBody(required = true) userRegisterDto: UserRegisterDto): Boolean {
        this.service.save(this.mapper.userRegisterDtoToUser(userRegisterDto))
        return true
    }
}