package com.jetherrodrigues

import java.util.*
import kotlin.Comparator

fun main() {
    println(getList())
    println(getList2())
    println(getList3())
}

/**
 * Compare anonymous class
 */
private fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object: Comparator<Int> {
        override fun compare(x: Int, y: Int) = x - y
    })
    return arrayList
}

/**
 * Compare lambda
 */
private fun getList2(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, { x, y -> x - y })
    return arrayList
}

/**
 * Using Collections to retrieve collections in descending orders
 */
fun getList3(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDescending()
}