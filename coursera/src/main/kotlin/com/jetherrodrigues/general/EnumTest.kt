package com.jetherrodrigues.general

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder

enum class Test {
    TEST1 ,
    TEST2
}

fun main() {
    println(convertDate("2019-06-06T00:00:00"))
    println(Test.valueOf("TEST1"))
    //println(Test.valueOf("JETHER"))
}

fun convertDate(toConvert: String): LocalDateTime {
    val formatter = DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd'T'HH:mm:ss").toFormatter()
    return LocalDateTime.parse(toConvert, formatter)
}


