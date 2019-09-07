package com.jetherrodrigues.domain.login

import com.jetherrodrigues.commons.ULID
import com.jetherrodrigues.domain.login.entities.User

interface UserRepository {
    fun create(user: User)

    fun findAll(): List<User>

    fun findById(id:ULID): User
}