package com.jetherrodrigues.resource.tables

import com.fasterxml.jackson.databind.ObjectMapper
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.Function
import org.postgresql.util.PGobject
import java.sql.PreparedStatement

/**
 * https://gist.githubusercontent.com/boonshift/65edda0782137d2b3825f2ddc1d93fe3/raw/5050932d4f51aa44499da3ac6eed960132d3dbb5/jsonb.kt
 * https://gist.github.com/boonshift/65edda0782137d2b3825f2ddc1d93fe3
 */
private class PostgreSQLJson<out T : Any>(private val klass: Class<T>, private val jsonMapper: ObjectMapper) : ColumnType() {
    override fun sqlType() = "jsonb"

    override fun setParameter(stmt: PreparedStatement, index: Int, value: Any?) {
        val obj = PGobject()
        obj.type = "jsonb"
        obj.value = value as String
        stmt.setObject(index, obj)
    }

    override fun valueFromDB(value: Any): Any {
        value as PGobject
        return try {
            jsonMapper.readValue(value.value, klass)
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Can't parse JSON: $value")
        }
    }

    override fun notNullValueToDB(value: Any): Any = jsonMapper.writeValueAsString(value)
    override fun nonNullValueToString(value: Any): String = "'${jsonMapper.writeValueAsString(value)}'"
}

class JsonKey(val key: String) : Expression<String>() {
    init {
        if (!key.matches("[a-zA-Z]+".toRegex())) throw IllegalArgumentException("Only simple json key allowed.")
    }

    override fun toSQL(queryBuilder: QueryBuilder) = key
}

inline fun <reified T> Column<Map<*,*>>.json(jsonKey: JsonKey): Function<T> {
    val columnType = when (T::class) {
        Int::class -> IntegerColumnType()
        String::class -> VarCharColumnType()
        Boolean::class -> BooleanColumnType()
        else -> throw java.lang.RuntimeException("Column type ${T::class} not supported for json field.")
    }

    return json(jsonKey, columnType)
}

fun <T : Any> Table.jsonb(name: String, klass: Class<T>, jsonMapper: ObjectMapper): Column<T> {
    return registerColumn(name, PostgreSQLJson(klass, jsonMapper))
}

fun <T> Column<Map<*, *>>.json(jsonKey: JsonKey, columnType: IColumnType): Function<T> {
    return PostgreSQLJsonVal(this, jsonKey, columnType)
}

private class PostgreSQLJsonVal<T>(val expr: Expression<*>, val jsonKey: JsonKey, override val columnType: IColumnType) : Function<T>(columnType) {
    override fun toSQL(queryBuilder: QueryBuilder) = "CAST((${expr.toSQL(queryBuilder)} ->> '${jsonKey.key}') AS ${columnType.sqlType()})"
}