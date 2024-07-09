package org.c0nstexpr.owo.dsl

@OwoDslMarker
fun interface OwoBuilder<T> {
    fun build(): T?
}

fun <T> empty() = OwoBuilder<T> { null }

fun <T> value(value: T?) = OwoBuilder { value }
