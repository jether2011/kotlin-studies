package com.jetherrodrigues.resource.tables

import org.jetbrains.exposed.sql.Table

object LayerTable : Table() {
    val id = ulid("id").primaryKey()
    val config = jsonb("config", Map::class.java, jsonMapper)
}