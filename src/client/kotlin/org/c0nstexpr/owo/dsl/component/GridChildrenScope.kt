package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder

open class GridChildrenScope(
    private val children: MutableList<MutableList<OwoBuilder<Component>>>
) {
    fun row(block: ChildrenScope.() -> Unit) {
        children.add(mutableListOf())
        ChildrenScope(children.last()).apply(block)
    }

    fun row(index: Int, block: ChildrenScope.() -> Unit) {
        while (children.size <= index) children.add(mutableListOf())

        ChildrenScope(children[index]).apply(block)
    }
}
