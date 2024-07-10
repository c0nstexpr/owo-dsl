package org.c0nstexpr.owo.dsl

@OwoDslMarker
fun interface OwoBuilder<T> {
    fun build(): T?
}
