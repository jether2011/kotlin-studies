package com.jetherrodrigues.domain.login.entities

enum class RoleType(val role: Role) {
    ADMIN(role = Role(name = "ADMIN", desc = "Administrator of the system")),
    ROOT(role = Role(name = "ROOT", desc = "Root User of the System")),
    USER(role = Role(name = "USER", desc = "Normal User of the System"));
}