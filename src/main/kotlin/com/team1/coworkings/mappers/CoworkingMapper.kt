package com.team1.coworkings.mappers

import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.dto.CoworkingDto
import com.team1.coworkings.entity.Coworking
import com.team1.coworkings.service.BookingService
import com.team1.coworkings.service.CoworkingInventoryService
import com.team1.coworkings.service.CoworkingService
import com.team1.coworkings.service.LikedCoworkingService
import com.team1.coworkings.utils.CommonUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CoworkingMapper @Autowired constructor(
    private val bookingService: BookingService,
    private val likedCoworkingService: LikedCoworkingService,
    private val coworkingInventoryService: CoworkingInventoryService,
) : BaseMapper<Coworking, CoworkingDto> {
    override fun entityToDto(entity: Coworking): CoworkingDto {
        return CoworkingDto(
            entity.id,
            entity.label,
            entity.description,
            entity.address,
            entity.capacity,
            entity.openFrom,
            entity.openTo,
            CommonUtils.getIdsList(entity.bookings),
            CommonUtils.getIdsList(entity.likedCoworkings),
            CommonUtils.getIdsList(entity.coworkingInventories)
        )
    }

    override fun dtoToEntity(dto: CoworkingDto): Coworking {
        return Coworking(
            dto.id,
            dto.label,
            dto.description,
            dto.address,
            dto.capacity,
            dto.openFrom,
            dto.openTo,
            bookingService.findAllById(dto.bookings),
            likedCoworkingService.findAllById(dto.likedCoworkings),
            coworkingInventoryService.findAllById(dto.coworkingInventories)
        )
    }
}