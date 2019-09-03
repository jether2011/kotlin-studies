package com.demo.ssj2k.controller

import com.demo.ssj2k.domain.Person

data class PersonContractResponse(
    val name: String,
    val age: Int
) {
    constructor(person: Person) : this (
        name = person.fullName,
        age = person.age
    )
}