package com.jetherrodrigues.resource.tables

import com.jetherrodrigues.commons.ULID
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.TransactionManager

class ULIDColumnType : ColumnType() {

    override fun sqlType(): String = TransactionManager.current().db.dialect.dataTypeProvider.binaryType(8)

    override fun valueFromDB(value: Any): Any= when(value) {
        is java.sql.Blob -> ULID(String(value.binaryStream.readBytes()))
        is ByteArray -> ULID(String(value))
        else -> error("Unexpected value of type ULID: ${value.javaClass.canonicalName}")
    }

    override fun notNullValueToDB(value: Any): Any = when(value) {
        is ULID -> value.value.toByteArray(Charsets.UTF_8)
        is ByteArray -> value
        else -> error("Unexpected value of type ULID: ${value.javaClass.canonicalName}")
    }

    override fun nonNullValueToString(value: Any): String = when(value) {
        is ULID -> value.value
        is ByteArray -> value.toString(Charsets.UTF_8)
        else -> "$value"
    }
}

fun Table.ulid(name: String) = registerColumn<ULID>(name, ULIDColumnType())