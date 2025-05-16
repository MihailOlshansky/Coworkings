package com.team1.coworkings.service

import com.team1.coworkings.base.BaseService
import com.team1.coworkings.entity.Booking
import com.team1.coworkings.exception.EntityNotFoundException
import com.team1.coworkings.exception.LogicalException
import com.team1.coworkings.repository.BookingRepository
import com.team1.coworkings.utils.CommonUtils
import com.team1.coworkings.utils.events.CoworkingWorkingHoursUpdatedEvent
import org.apache.commons.lang3.time.DateUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
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

    @EventListener
    fun handleCoworkingUpdatedEvent(event: CoworkingWorkingHoursUpdatedEvent) {
        val bookings = repository.findAllByCoworkingId(event.coworkingId)
        bookings.forEach { booking ->
            if (!isBookingValid(booking, event.newOpenFrom, event.newOpenTo)) {
                delete(booking)
            }
        }
    }

    private fun isBookingValid(booking: Booking, openFrom: String, openTo: String): Boolean {
        val openFromDate = CommonUtils.setDateTime(booking.dateFrom, openFrom)
        val openToDate = CommonUtils.setDateTime(booking.dateFrom, openTo)

        return booking.dateFrom.after(openFromDate) && booking.dateTo.before(openToDate)
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