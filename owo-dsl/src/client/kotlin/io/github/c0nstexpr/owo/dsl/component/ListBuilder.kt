package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.dslBuilder

open class ListBuilder<T : Any>(val list: MutableList<DslBuilder<T>> = mutableListOf()) :
    DslBuilder<List<T>> by dslBuilder({
        list.map { it.built ?: return@dslBuilder null }.toList()
    }) {
    inline fun add(crossinline provider: (Int) -> DslBuilder<T>) = list.add(provider(list.size))
}

inline fun <T : Any> list(crossinline block: ListBuilder<T>.() -> Unit) =
    ListBuilder<T>().apply(block)
