package com.jetherrodrigues.general

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.DateTimeFormatterBuilder
import java.text.SimpleDateFormat
import java.util.Date

fun main() {

    val formatter: DateTimeFormatter  = DateTimeFormatterBuilder()
                                            .appendPattern("yyyy-MM-dd")
                                            .toFormatter()

    val formatedDate = SimpleDateFormat("yyyy-MM-dd").format(DateTime.now().plus(1).toDate())
    val date:Date = SimpleDateFormat("yyyy-MM-dd").parse(formatedDate)

    println(
       DateTime.now().toString(formatter)
    )

    println(
        formatedDate
    )

    println(
        date
    )
}