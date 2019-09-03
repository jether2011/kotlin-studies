package com.demo.ssj2k.controller

import com.demo.ssj2k.domain.Person

data class PersonResponse(
    val name: String,
    val age: Int
) {
    constructor(person: Person) : this (
        name = person.getFullName(),
        age = person.age
    )
}