package com.jetherrodrigues

import java.util.*

fun main() {
    println(joinOptions(Arrays.asList("a", "b", "c")))
}

private fun joinOptions(options: Collection<String>) = options.joinToString(prefix="[", postfix="]")