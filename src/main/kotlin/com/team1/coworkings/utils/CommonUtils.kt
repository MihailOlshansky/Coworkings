package com.team1.coworkings.utils

import com.team1.coworkings.base.BaseEntity
import org.apache.commons.lang3.time.DateUtils
import java.util.Date
import java.util.stream.Collectors
import kotlin.streams.toList

class CommonUtils {
    companion object{
        private val TIME_REGEX: Regex = Regex("""(([0-1]\d)|\d|2[0-3]):(([0-5]\d)|\d)""")

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

        fun correctDate(date: String): String {
            var result = date
            while (date.length < 5) {
                result = "0${result}"
            }

            return result
        }

        fun checkTimeFormat(time: String): Boolean {
            return TIME_REGEX.matches(time)
        }
    }
}