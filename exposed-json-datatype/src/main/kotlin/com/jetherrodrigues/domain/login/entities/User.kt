package com.jetherrodrigues.domain.login.entities

import com.jetherrodrigues.commons.ULID

data class User (
    val id: ULID = ULID.random(),
    val name: String,
    val email: String,
    val roles: List<*>
)