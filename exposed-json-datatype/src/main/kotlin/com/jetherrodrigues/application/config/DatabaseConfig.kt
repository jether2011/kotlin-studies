package com.jetherrodrigues.application.config

import com.jetherrodrigues.resource.tables.LayerTable
import com.jetherrodrigues.resource.tables.UserTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

class DatabaseConfig {
    private val dataSource: DataSource

    init {
        dataSource = HikariConfig().let { config ->
            config.jdbcUrl = "jdbc:postgresql://localhost:5432/usersdb"
            config.driverClassName = "org.postgresql.Driver"
            config.username = "postgres"
            config.password = "postgres123"

            HikariDataSource(config)
        }
    }

    fun connect() {
        Database.connect(dataSource)
    }

    fun createSchemas() = try {
        transaction {
            SchemaUtils.drop(UserTable)
            SchemaUtils.create(UserTable)

            SchemaUtils.drop(LayerTable)
            SchemaUtils.create(LayerTable)
        }
    } catch (e: ExposedSQLException) {
        throw Exception(e.message)
    }
}