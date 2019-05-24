package com.jetherrodrigues.week1

fun main() {
    println("First ${foo()}, second ${foo()}")
}

private fun foo(): String {
    println("Calculating foo...")
    return "foo"
}