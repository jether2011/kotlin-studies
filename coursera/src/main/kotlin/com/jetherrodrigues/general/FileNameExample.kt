package com.jetherrodrigues.general

import org.joda.time.DateTime

fun main() {
    print(
        "REM_TAG.FLASH.${DateTime().toString("yyMMdd")}${DateTime().millis}.REM"
    )
}
