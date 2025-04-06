package com.team1.coworkings.utils

import com.team1.coworkings.base.BaseEntity
import org.apache.commons.lang3.time.DateUtils
import java.util.Date
import java.util.stream.Collectors
import kotlin.streams.toList

class CommonUtils {
    companion object{
        fun getIdsList(entityList : Collection<BaseEntity>) : List<Long> {
            return entityList.stream()
                .map { it -> it.getPk() }
                .collect(Collectors.toList())
        }

        fun setDateTime(day: Date, time: String): Date {
            val tmp: List<Int> = time.split(":").stream()
                .map { it.toInt() }
                .toList()

            return DateUtils.setMinutes(DateUtils.setHours(day, tmp[0]), tmp[1])
        }
    }
}