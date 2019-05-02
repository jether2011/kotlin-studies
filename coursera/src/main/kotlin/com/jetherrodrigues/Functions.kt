package com.jetherrodrigues

fun main() {
    println(max(2, 3))
    println(max2(2, 3))

    displayMax(5, 6)
    displayMax2(5, 6)
}

fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}

fun displayMax2(a: Int, b: Int): Unit {
    println(max(a, b))
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b