package com.jetherrodrigues

fun main() {
    /**
     * val is ready-only variable like a final in java
     */
    val question:String = "life, the universe, and everything"
    println("${question}?")

    /**
     * var can be reassigned
     */
    var answer = 0
    answer = 50
    println(answer)

    val mutableList = mutableListOf("Java")
    println(mutableList)

    mutableList.add("Kotlin")
    println(mutableList)

    /**
     * can't modify an immutable list
     */
    val immutableList = listOf("Java")
    //list.add("Kotlin")
    println(immutableList)
}