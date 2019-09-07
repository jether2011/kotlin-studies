package com.jetherrodrigues.commons.extensions

import com.jetherrodrigues.commons.ULID

fun String.toUlid(): ULID = ULID(this)