package com.jetherrodrigues.domain.login

import com.jetherrodrigues.commons.extensions.toUlid
import com.jetherrodrigues.domain.login.entities.User

class UserService(private val repository: UserRepository) {
    fun findAll() : List<User> = repository.findAll()

    fun findById(id: String) : User = repository.findById(id.toUlid())

    fun create(user: User) : User {
        repository.create(user)
        return user
    }
}