package com.jetherrodrigues

fun main() {
    println(getPattern())
}

private val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

private fun getPattern(): String = """\d{2} ${ month } \d{4}"""