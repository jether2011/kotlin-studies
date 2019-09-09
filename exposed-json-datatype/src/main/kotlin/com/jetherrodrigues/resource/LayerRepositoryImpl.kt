package com.jetherrodrigues.resource

import com.jetherrodrigues.commons.ULID
import com.jetherrodrigues.domain.exceptions.LayerNotFoundException
import com.jetherrodrigues.domain.layer.entities.Layer
import com.jetherrodrigues.domain.login.LayerRepository
import com.jetherrodrigues.resource.tables.LayerTable
import com.jetherrodrigues.resource.tables.jsonMapper
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class LayerRepositoryImpl : LayerRepository {

    override fun create(layer: Layer) {
        transaction {
            LayerTable.insert {
                it[id] = layer.id
                it[config] = jsonMapper.readerFor(Map::class.java).readValue(layer.config)
            }
        }
    }

    override fun findAll(): List<Layer> = transaction {
        LayerTable.selectAll().map { it.toObject() }
    }

    override fun findById(id: ULID): Layer = transaction {
        LayerTable.select {
            LayerTable.id eq id
        }.firstOrNull()?.toObject() ?: throw LayerNotFoundException(id)
    }

    private fun ResultRow.toObject() = Layer(
        id = this[LayerTable.id],
        config = jsonMapper.writeValueAsString(this[LayerTable.config])
    )
}