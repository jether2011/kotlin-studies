package com.jetherrodrigues

fun main() {
    println(getPeople())
}

data class Person(val name:String, val age:Int)

private fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}