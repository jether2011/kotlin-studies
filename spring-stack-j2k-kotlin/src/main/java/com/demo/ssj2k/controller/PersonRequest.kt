package com.demo.ssj2k.controller

import com.demo.ssj2k.domain.Person
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PersonRequest(
    @field:NotEmpty val firstName: String,
    @field:NotEmpty val lastName: String,
    @field:NotNull val age: Int
) {
    constructor(person: Person) :
        this(person.firstName, person.lastName, person.age)

    fun toDomain() = Person(firstName = firstName, lastName = lastName, age = age)
}