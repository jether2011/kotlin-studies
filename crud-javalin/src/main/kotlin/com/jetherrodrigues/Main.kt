package com.jetherrodrigues

import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.Javalin

/**
 * @author Jether Rodrigues
 */
fun main(args: Array<String>) {

    val userDao = UserDAO()

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start(7000)

    app.routes {

        get("/users") { ctx ->
            ctx.json(userDao.getUsers())
        }

        get("/users/:user-id") { ctx ->
            ctx.json(userDao.findById(ctx.pathParam("user-id").toInt())!!)
        }

        get("/users/email/:email") { ctx ->
            ctx.json(userDao.findByEmail(ctx.pathParam("email"))!!)
        }

        post("/users") { ctx ->
            val user = ctx.body<User>()
            userDao.save(name = user.name, email = user.email)
            ctx.status(201)
        }

        patch("/users/:user-id") { ctx ->
            val user = ctx.body<User>()
            userDao.update(
                id = ctx.pathParam("user-id").toInt(),
                user = user
            )
            ctx.status(204)
        }

        delete("/users/:user-id") { ctx ->
            userDao.delete(ctx.pathParam("user-id").toInt())
            ctx.status(204)
        }
    }
}

