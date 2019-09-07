package com.jetherrodrigues.application.web.controller.request

import com.jetherrodrigues.domain.login.entities.RoleType
import com.jetherrodrigues.domain.login.entities.User
import org.valiktor.functions.isEmail
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isNotEmpty
import org.valiktor.validate

/**
 * https://hype.codes/how-convert-list-map-kotlin
 */
data class UserRequest (
    val name: String,
    val email: String,
    val roles: List<RoleType>
) {
    init {
        validate(this) {
            validate(UserRequest::name).isNotBlank()
            validate(UserRequest::email).isNotBlank().isEmail()
            validate(UserRequest::roles).isNotEmpty()
        }
    }

    fun toUser() : User = User (
        name = name,
        email = email,
        roles = roles.map { it.role }
    )
}