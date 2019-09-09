package com.jetherrodrigues.application.web.controller.request

import com.jetherrodrigues.domain.layer.entities.Layer
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

data class LayerRequest(val config: String) {

    init {
        validate(this) {
            validate(LayerRequest::config).isNotBlank()
        }
    }

    fun toLayer() : Layer = Layer(config = config)
}
