package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.wispforest.owo.ui.core.Component

open class GridChildrenBuilder(val children: MutableList<GridRowBuilder> = mutableListOf()) :
    DslBuilder<List<Map<Int, Component>>> by
    dslBuilder({ children.map { it.built ?: return@dslBuilder null }.toList() }) {
    inline fun row(crossinline block: GridRowBuilder.() -> Unit) {
        children.add(gridRow(children.size, block))
    }
}

inline fun gridChildren(crossinline block: GridChildrenBuilder.() -> Unit) =
    GridChildrenBuilder().also(block)
