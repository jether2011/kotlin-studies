package com.jetherrodrigues.resource.tables

import com.fasterxml.jackson.databind.ObjectMapper
import org.jetbrains.exposed.sql.Table

val jsonMapper = ObjectMapper()

object UserTable : Table() {
    val id = ulid("id").primaryKey()
    val name = varchar("name", 36)
    val email = varchar("email", 36)
    val roles = jsonb("roles", List::class.java, jsonMapper)
}