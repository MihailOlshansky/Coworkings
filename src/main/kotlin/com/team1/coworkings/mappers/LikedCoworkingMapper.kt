package com.team1.coworkings.mappers

import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.dto.LikedCoworkingDto
import com.team1.coworkings.entity.LikedCoworking
import com.team1.coworkings.service.CoworkingService
import com.team1.coworkings.service.LikedCoworkingService
import com.team1.coworkings.service.UserService
import com.team1.coworkings.utils.CommonUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LikedCoworkingMapper @Autowired constructor(
    private val userService: UserService,
    private val coworkingService: CoworkingService
) : BaseMapper<LikedCoworking, LikedCoworkingDto> {
    override fun entityToDto(entity: LikedCoworking): LikedCoworkingDto {
        return LikedCoworkingDto(
            entity.id,
            entity.likeDate,
            entity.coworking.id,
            entity.user.id
        )
    }

    override fun dtoToEntity(dto: LikedCoworkingDto): LikedCoworking {
        return LikedCoworking(
            dto.id,
            dto.likeDate,
            coworkingService.findByIdNonNull(dto.coworking),
            userService.findByIdNonNull(dto.user)
        )
    }
}