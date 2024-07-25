package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.dslBuilder

open class ListBuilder<T : Any> protected constructor(
    private val list: MutableList<DslBuilder<T>> = mutableListOf()
) : DslBuilder<List<T>> by dslBuilder({
        list.map { it.built ?: return@dslBuilder null }.toList()
    }) {
    protected fun add(block: DslBuilder<T>) = list.add(block)
}
