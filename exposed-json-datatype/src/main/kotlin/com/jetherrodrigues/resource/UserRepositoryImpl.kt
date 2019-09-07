package com.jetherrodrigues.resource

import com.jetherrodrigues.commons.ULID
import com.jetherrodrigues.domain.exceptions.UserNotFoundException
import com.jetherrodrigues.domain.login.UserRepository
import com.jetherrodrigues.domain.login.entities.User
import com.jetherrodrigues.resource.tables.UserTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository  {

    override fun create(user: User) {
        transaction {
            UserTable.insert {
                it[id] = user.id
                it[name] = user.name
                it[email] = user.email
                it[roles] = user.roles
            }
        }
    }

    override fun findAll(): List<User> = transaction {
        UserTable.selectAll().map { it.toObject() }
    }

    override fun findById(id: ULID): User = transaction {
        UserTable.select {
            UserTable.id eq id
        }.firstOrNull()?.toObject() ?: throw UserNotFoundException(id)
    }

    private fun ResultRow.toObject() = User(
        id = this[UserTable.id],
        name = this[UserTable.name],
        email = this[UserTable.email],
        roles = this[UserTable.roles].map { it }
    )
}