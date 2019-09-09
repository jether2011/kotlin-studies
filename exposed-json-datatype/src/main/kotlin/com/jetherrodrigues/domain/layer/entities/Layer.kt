package com.jetherrodrigues.domain.layer.entities

import com.jetherrodrigues.commons.ULID

data class Layer(val id:ULID = ULID.random(), val config: String)