package com.jetherrodrigues.commons

import io.azam.ulidj.ULID as ulid

class ULID(value: String) : Comparable<ULID> {
    val value: String

    init {
        if(ulid.isValid(value))
            this.value = value
        else
            throw IllegalArgumentException("Invalid ULID")
    }

    companion object {
        fun random(): ULID {
            return ULID(ulid.random())
        }
    }

    override fun compareTo(other: ULID): Int {
        return value.compareTo(other.value)
    }

    override fun toString(): String {
        return value
    }
}