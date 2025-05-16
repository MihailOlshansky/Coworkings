package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.Booking
import com.team1.coworkings.exception.EntityNotFoundException
import com.team1.coworkings.exception.LogicalException
import com.team1.coworkings.repository.BookingRepository
import com.team1.coworkings.utils.CommonUtils
import org.apache.commons.lang3.time.DateUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class BookingService @Autowired constructor(
    private val repository: BookingRepository,
    private val coworkingService: CoworkingService
): BaseService<Booking> {
    private val BEGIN_TIME: String = "00:00"

    override fun getRepository(): JpaRepository<Booking, Long> {
        return repository
    }

    override fun getEntityName(): String {
        return "Бронирование"
    }

    fun bookCoworking(booking: Booking) {
        checkBooking(booking)

        this.save(booking)
    }

    fun cancelBooking(id: Long) {
        repository.deleteById(id)
    }

    private fun checkBooking(booking: Booking) {
        if (!booking.dateFrom.before(booking.dateTo)
            || CommonUtils.setDateTime(booking.dateFrom, BEGIN_TIME) != CommonUtils.setDateTime(booking.dateTo, BEGIN_TIME)
        ) {
            throw LogicalException("Неверный период бронирования")
        }

        val dateFrom = CommonUtils.setDateTime(booking.dateFrom, booking.coworking.openFrom)
        val dateTo = CommonUtils.setDateTime(booking.dateFrom, booking.coworking.openTo)

        val isBusy: Boolean = repository.findAllByCoworkingId(booking.coworking.id).stream()
            .anyMatch { it.dateFrom.after(dateFrom) && it.dateFrom.before(dateTo)
                    || it.dateTo.after(dateFrom) && it.dateTo.before(dateTo)}
        if (isBusy) {
            throw LogicalException("На данный период коворкинг забронирован")
        }
    }
}