package com.team1.coworkings.mappers

import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.dto.BookingDto
import com.team1.coworkings.entity.Booking
import com.team1.coworkings.exception.EntityNotFoundException
import com.team1.coworkings.service.BookingService
import com.team1.coworkings.service.CoworkingService
import com.team1.coworkings.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BookingMapper @Autowired constructor(
    private val userService: UserService,
    private val coworkingService: CoworkingService
) : BaseMapper<Booking, BookingDto> {
    override fun entityToDto(entity: Booking): BookingDto {
        return BookingDto(
            id = entity.id,
            dateFrom = entity.dateFrom,
            dateTo = entity.dateTo,
            personsAmount = entity.personsAmount,
            coworking = entity.coworking.id,
            user = entity.user.id)
    }

    override fun dtoToEntity(dto: BookingDto): Booking {
        val user = userService.findByIdNonNull(dto.user)
        val coworking = coworkingService.findByIdNonNull(dto.coworking)

        return Booking(dto.id, dto.dateFrom, dto.dateTo, dto.personsAmount, coworking, user)
    }
}