package com.jetherrodrigues.week2

enum class Color {
    BLUE, ORANGE, RED
}

enum class Color2 {
    BLUE, ORANGE, RED, GREEN, INDIGO, VIOLET, YELLOW
}

fun getColor(color: Color) : String = when(color) {
    Color.BLUE -> "cold"
    Color.ORANGE -> "mild"
    Color.RED -> "hot"
}

fun getMixColor(c1: Color2, c2: Color2) : Any = when(setOf(c1, c2)) {
    setOf(Color2.RED, Color2.YELLOW) -> Color2.ORANGE
    setOf(Color2.YELLOW, Color2.BLUE) -> Color2.GREEN
    setOf(Color2.BLUE, Color2.VIOLET) -> Color2.INDIGO
    else -> throw Exception("Dirty color")
}

fun main() {
    println(getColor(Color.RED))

    println(getMixColor(Color2.RED, Color2.YELLOW))
}