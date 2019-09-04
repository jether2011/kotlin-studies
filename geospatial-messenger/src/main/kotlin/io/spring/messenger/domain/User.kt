package io.spring.messenger.domain

import org.postgis.Point

class User(
    val userName  : String,
    val firstName : String,
    val lastName  : String,
    val location  : Point? = null
)
