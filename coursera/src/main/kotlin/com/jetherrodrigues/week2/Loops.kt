package com.jetherrodrigues.week2

private val list1 = listOf("a", "b", "c")

fun printElementOfList(list: List<String>) {
    for (value in list) print(value)
}

fun printIndexedElementOfList(list: List<String>) {
    for ((index, value )in list.withIndex()) println("$index: $value")
}

private val map = mapOf(1 to "one",
                        2 to "two",
                        3 to "three")

fun printElementOfMap(map: Map<Int, String>) {
    for ((key, value) in map) println("$key = $value")
}

fun testingFor1() {
    for (i in 1..9) print(i)
}

fun testingFor2() {
    for (i in 1 until 9) print(i)
}

fun testingFor3() {
    for (i in 9 downTo 1 step 2) print(i)
}

fun testingFor4() {
    for (ch in "abc") print(ch + 1)
}

fun testingFor5() {
    for (c in '0' until '9') print(c)
}

fun main() {
    printElementOfList(list1)
    println()
    printElementOfMap(map)
    println()
    printIndexedElementOfList(list1)
    println()
    testingFor1()
    println()
    testingFor2()
    println()
    testingFor3()
    println()
    testingFor4()
    println()
    testingFor5()
}