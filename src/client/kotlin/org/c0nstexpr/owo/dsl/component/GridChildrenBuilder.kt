package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder

open class GridChildrenBuilder : OwoBuilder<List<Map<Int, Component>>> {
    val children = mutableListOf<GridRowBuilder>()

    inline fun row(crossinline block: GridRowBuilder.() -> Unit) {
        children.add(gridRow(children.size, block))
    }

    override fun build() = children.map { it.build() }

    override val canBuild get() = children.all { it.canBuild }
}

inline fun gridChildren(crossinline block: GridChildrenBuilder.() -> Unit) =
    GridChildrenBuilder().apply(block)
