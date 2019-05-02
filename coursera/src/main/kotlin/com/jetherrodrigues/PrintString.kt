package com.jetherrodrigues

fun main() {
    println("First ${foo()}, second ${foo()}")
}

private fun foo(): String {
    println("Calculating foo...")
    return "foo"
}