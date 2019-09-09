package com.jetherrodrigues.domain.login

import com.jetherrodrigues.commons.extensions.toUlid
import com.jetherrodrigues.domain.layer.entities.Layer

class LayerService(private val repository: LayerRepository) {
    fun findAll() : List<Layer> = repository.findAll()

    fun findById(id: String) : Layer = repository.findById(id.toUlid())

    fun create(layer: Layer) : Layer {
        repository.create(layer)
        return layer
    }
}