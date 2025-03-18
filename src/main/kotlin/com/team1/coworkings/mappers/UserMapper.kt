package com.team1.coworkings.mappers

import com.google.common.hash.Hashing
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.constants.RoleCodes
import com.team1.coworkings.dto.UserDto
import com.team1.coworkings.dto.UserRegisterDto
import com.team1.coworkings.entity.Role
import com.team1.coworkings.entity.User
import com.team1.coworkings.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class UserMapper @Autowired constructor(
    private val roleService: RoleService
) : BaseMapper<User, UserDto> {
    override fun entityToDto(entity: User): UserDto {
        return UserDto(entity.id, entity.login, entity.name, entity.email, entity.role.id)
    }

    override fun dtoToEntity(dto: UserDto): User {
        var role: Role? = roleService.findById(dto.role)
        if (role == null) {
            role = roleService.findByCode(RoleCodes.USER)
        }
        return User(
            id = dto.id,
            login = dto.login,
            name = dto.name,
            email = dto.email,
            role = role)
    }

    fun userRegisterDtoToUser(userRegisterDto: UserRegisterDto): User {
        return User(
            login = userRegisterDto.login,
            name = userRegisterDto.name,
            email = userRegisterDto.email,
            password = encrypt(userRegisterDto.password),
            role = roleService.findByCode(RoleCodes.USER)
        )
    }

    private fun encrypt(password: String): String {
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString()
    }
}