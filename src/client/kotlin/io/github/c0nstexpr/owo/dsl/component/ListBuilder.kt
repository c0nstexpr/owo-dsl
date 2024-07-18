package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder

open class ListBuilder<T : Any> : OwoBuilder<List<T>> {
    @PublishedApi
    internal val list = mutableListOf<OwoBuilder<T>>()

    inline fun <U : OwoBuilder<T>> add(
        crossinline provider: () -> U,
        crossinline block: (Int, U) -> Unit
    ) {
        val builder = provider()
        block(list.size, builder)
        list.add(builder)
    }

    override fun build() = list.map { it.build() }

    override val canBuild get() = list.all { it.canBuild }
}

inline fun <T : Any> list(crossinline block: ListBuilder<T>.() -> Unit) =
    ListBuilder<T>().apply(block)
