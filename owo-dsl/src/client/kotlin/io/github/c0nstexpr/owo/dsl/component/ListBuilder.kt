package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.canBuild

open class ListBuilder<T : Any> : DslBuilder<List<T>> {
    @PublishedApi
    internal val list = mutableListOf<DslBuilder<T>>()

    inline fun add(crossinline provider: (Int) -> DslBuilder<T>) = list.add(provider(list.size))

    override fun build() = list.map { it.build() }

    override val canBuild get() = list.all { it.canBuild }
}

inline fun <T : Any> list(crossinline block: ListBuilder<T>.() -> Unit) =
    ListBuilder<T>().apply(block)
