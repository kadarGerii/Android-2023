package main

import java.time.LocalDate

data class Date(
    val year: Int = LocalDate.now().year,
    val month: Int = LocalDate.now().monthValue,
    val day: Int = LocalDate.now().dayOfMonth
) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        return when {
            this.year != other.year -> this.year - other.year
            this.month != other.month -> this.month - other.month
            else -> this.day - other.day
        }
    }
}

fun Date.isLeapYear(): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun Date.isValid(): Boolean {
    if (month < 1 || month > 12) return false
    if (day < 1) return false

    val daysInMonth = when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (isLeapYear()) 29 else 28
        else -> 0
    }

    return day <= daysInMonth
}