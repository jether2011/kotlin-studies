package com.jetherrodrigues

fun main() {
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))

    println(listOf(1, 2, 3).joinToString(postfix = "."))

    println(listOf(1, 2, 3).joinToString())

    displaySeparator('#', 5)
    println()

    displaySeparator('#')
    println()

    displaySeparator()
    println()

    displaySeparator(size = 5)
    println()

    displaySeparator(size = 3, character = '5')
}

private fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        print(character)
    }
}

