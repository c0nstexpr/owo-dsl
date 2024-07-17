package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder

open class ChildrenBuilder<T> : OwoBuilder<List<T>> {
    @PublishedApi
    internal val children = mutableListOf<OwoBuilder<T>>()

    inline fun <U : OwoBuilder<T>> child(
        crossinline provider: () -> U,
        crossinline block: (Int, U) -> Unit
    ) {
        val builder = provider()
        block(children.size, builder)
        children.add(builder)
    }

    override fun build() = children.map { it.build() }

    override val canBuild get() = children.all { it.canBuild }
}

inline fun <T> children(crossinline block: ChildrenBuilder<T>.() -> Unit) =
    ChildrenBuilder<T>().apply(block)
