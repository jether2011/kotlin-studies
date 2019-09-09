package com.jetherrodrigues.application.web.controller

import com.jetherrodrigues.application.web.controller.request.LayerRequest
import com.jetherrodrigues.domain.layer.entities.Layer
import com.jetherrodrigues.domain.login.LayerService
import io.javalin.http.Context

class LayerController(private val service: LayerService) {
    fun findAll() = service.findAll()

    fun findById(ctx: Context) : Layer {
        val id = ctx.pathParam("id")
        return service.findById(id)
    }

    fun create(ctx: Context) : Layer {
        val layer = ctx.bodyAsClass(LayerRequest::class.java).toLayer()
        return service.create(layer)
    }
}