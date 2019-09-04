package io.spring.messenger.domain

import org.postgis.Point

class Message(
    val content  : String? = null,
    val author   : String? = null,
    val location : Point? = null,
    val id       : Int?   = null
)

