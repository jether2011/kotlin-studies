package com.jetherrodrigues

/**
 * https://medium.com/@elye.project/kotlin-slow-list-and-lazy-sequence-61691fc974c5
 */
fun main() {
    calcByListLambda()
    println("=====================================================")
    calcBySequenceLambda()
    println("=====================================================")
    calcBySequenceOf()
}

fun calcByListLambda() {
    val result = list()
        .map {
            println("In map...")
            it * 2
        }.filter {
            println("In filter...")
            it % 3 == 0
        }
    println("Before average...")
    println("Average [ %s ]".format(result.average()))
}

fun calcBySequenceLambda() {
    val result = list().asSequence()
        .map {
            println("In map...")
            it * 2
        }.filter {
            println("In filter...")
            it % 3 == 0
        }
    println("Before average...")
    println("Average [ %s ]".format(result.average()))
}

fun calcBySequenceOf() {
    val result = sequence()
        .map{
            println("In Map $it")
            it * 2
        }.filter {
            println("In Filter $it")
            it % 3  == 0
        }
    println(result.first())
}

fun list(): List<Int> {
    return listOf(1,2,3,4,5,6)
}

fun sequence(): Sequence<Int> {
    return sequenceOf(1,2,3,4,5,6)
}