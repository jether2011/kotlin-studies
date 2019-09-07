package com.jetherrodrigues.application

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jetherrodrigues.application.config.DatabaseConfig
import com.jetherrodrigues.application.config.appModules
import com.jetherrodrigues.application.web.routes.UserRoutes
import io.javalin.Javalin
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext

import com.jetherrodrigues.domain.exceptions.UserNotFoundException
import org.koin.standalone.inject

const val SERVER_PORT = 7000

/**
 * @author Jether Rois
 *
 * based on: https://javalin.io/documentation#server-setup
 */
class Application : KoinComponent {
    private val userRoutes : UserRoutes by inject()
    private val databaseConfig = DatabaseConfig()

    private fun setup(): Javalin {
        StandAloneContext.startKoin(appModules)
        jacksonObjectMapper()

        return Javalin.create()
                .also { app ->
                    app.events { listener ->
                        listener.serverStartFailed { StandAloneContext.stopKoin() }
                        listener.serverStopped { StandAloneContext.stopKoin() }
                    }

                    app.routes {
                        userRoutes.register(app)
                    }

                    app.exception(UserNotFoundException::class.java) { exception, ctx ->
                        ctx.status(404)
                        exception.message?.let { ctx.result(it) }
                    }
                }
    }

    fun initialize() {
        databaseConfig.connect()
        databaseConfig.createSchemas()
        setup().start(SERVER_PORT)
    }
}

fun main() {
    Application().initialize()
}