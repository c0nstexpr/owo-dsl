package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder

open class ChildrenBuilder : OwoBuilder<List<Component>> {
    @PublishedApi
    internal val children = mutableListOf<OwoBuilder<Component>>()

    inline fun <T : OwoBuilder<Component>> child(
        crossinline provider: () -> T,
        crossinline block: (Int, T) -> Unit
    ) {
        val builder = provider()
        block(children.size, builder)
        children.add(builder)
    }

    override fun build() = children.map { it.build() }

    override val canBuild get() = children.all { it.canBuild }
}

inline fun children(crossinline block: ChildrenBuilder.() -> Unit) = ChildrenBuilder().apply(block)
