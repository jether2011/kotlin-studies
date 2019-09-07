package com.jetherrodrigues.application.web.controller

import com.jetherrodrigues.application.web.controller.request.UserRequest
import com.jetherrodrigues.domain.login.UserService
import com.jetherrodrigues.domain.login.entities.User
import io.javalin.http.Context

class UserController(private val service: UserService) {
    fun findAll() = service.findAll()

    fun findById(ctx: Context) : User {
        val id = ctx.pathParam("id")
        return service.findById(id)
    }

    fun create(ctx: Context) : User {
        val user = ctx.bodyAsClass(UserRequest::class.java).toUser()
        return service.create(user)
    }
}