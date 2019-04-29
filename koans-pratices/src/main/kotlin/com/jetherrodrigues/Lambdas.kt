package com.jetherrodrigues

import java.util.*

fun main() {
    println(containsEven(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)))
}

private fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }