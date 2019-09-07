package com.jetherrodrigues.domain.exceptions

import com.jetherrodrigues.commons.ULID

data class UserNotFoundException(val id: ULID)
    : RuntimeException("The user $id was not found")