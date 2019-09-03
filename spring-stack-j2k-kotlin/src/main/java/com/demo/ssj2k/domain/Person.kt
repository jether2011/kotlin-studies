package com.demo.ssj2k.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
    @Id val id: String = UUID.randomUUID().toString(),
    val firstName: String,
    val lastName: String,
    val age: Int
) {

    fun getFullName() = "$firstName $lastName"
}