package com.jetherrodrigues.domain.exceptions

import com.jetherrodrigues.commons.ULID

data class LayerNotFoundException(val id: ULID)
    : RuntimeException("The layer $id was not found")