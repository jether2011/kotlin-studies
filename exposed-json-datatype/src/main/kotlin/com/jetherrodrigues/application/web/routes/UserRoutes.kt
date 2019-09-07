package com.jetherrodrigues.application.web.routes

import com.jetherrodrigues.application.web.controller.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.Handler

class UserRoutes(private val controller: UserController) {
    fun register(app: Javalin) {
        app.routes {
            path("users") {
                get(Handler { it.json(controller.findAll()) })

                path(":id") {
                    get( Handler { it.json(controller.findById(it)) })
                }

                post(
                    Handler { it.json(controller.create(it)) }
                )
            }
        }
    }
}