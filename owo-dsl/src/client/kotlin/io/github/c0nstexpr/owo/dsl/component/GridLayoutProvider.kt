package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.GridChild
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.GridLayout

open class GridLayoutProvider :
    BaseParentComponentProvider(),
    GridChildrenProvider {
    override var children = listOf<DslBuilder<GridChild>>()

    override var rows = 0

    override var columns = 0

    override fun provide(): GridLayout? {
        return Containers.grid(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            rows,
            columns
        ).also(::applyTo)
    }

    protected fun applyTo(component: GridLayout) {
        super<BaseParentComponentProvider>.applyTo(component)
        super<GridChildrenProvider>.applyTo(component)

        children.map { it.built ?: return }
            .toList()
            .forEach { it.run { component.child(child, index.row, index.column) } }
    }
}
