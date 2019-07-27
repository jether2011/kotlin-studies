package com.jetherrodrigues.general

data class Address(
    val address: String,
    val primary: Boolean
)
fun main() {
    val address = listOf(
        Address("HOUSE", false),
        Address("HOME", true)
    )

    println(
        address.asSequence().filter { it.address == "SHIPPING" }.firstOrNull() ?: address.first { it.primary }
    )
}
