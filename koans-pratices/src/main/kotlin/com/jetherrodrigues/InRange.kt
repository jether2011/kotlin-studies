package com.jetherrodrigues

fun main() {
    println(checkInRange(
         MyDate(2019, 4, 10),
         MyDate(2019, 4, 15),
         MyDate(2019, 4,29)
    ))
}

class DateRange(val start: MyDate, val endInclusive: MyDate){
    operator fun contains(date: MyDate): Boolean = start <= date && date <= endInclusive
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}