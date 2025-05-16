package com.team1.coworkings.controller

import com.team1.coworkings.base.BaseController
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.BookingDto
import com.team1.coworkings.entity.Booking
import com.team1.coworkings.mappers.BookingMapper
import com.team1.coworkings.service.BookingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("booking/")
class BookingController @Autowired constructor(
    private val service: BookingService,
    private val mapper: BookingMapper
) : BaseController<Booking, BookingDto> {
    override fun getService(): BaseService<Booking> {
        return this.service
    }

    override fun getMapper(): BaseMapper<Booking, BookingDto> {
        return this.mapper
    }

    @PostMapping("book")
    fun bookCoworking(@RequestBody bookingDto: BookingDto) {
        this.service.bookCoworking(this.mapper.dtoToEntity(bookingDto))
    }

    @DeleteMapping("{id}")
    fun cancelBooking(@PathVariable id: Long) {
        this.service.cancelBooking(id)
    }
}