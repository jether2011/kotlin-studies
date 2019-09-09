package com.jetherrodrigues.domain.login

import com.jetherrodrigues.commons.ULID
import com.jetherrodrigues.domain.layer.entities.Layer

interface LayerRepository {
    fun create(layer: Layer)

    fun findAll(): List<Layer>

    fun findById(id:ULID): Layer
}