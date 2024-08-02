package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.GridChild
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.GridLayout

open class GridLayoutBuilder :
    BaseParentComponentBuilder(),
    GridChildrenBuilder {
    override var children = listOf<DslBuilder<GridChild>>()

    override var rows = 0

    override var columns = 0

    override fun provide(): GridLayout? {
        return Containers.grid(
            horizontalSizing.value ?: return null,
            verticalSizing.value ?: return null,
            rows,
            columns
        ).also(::applyTo)
    }

    protected fun applyTo(component: GridLayout) {
        super<BaseParentComponentBuilder>.applyTo(component)
        super<GridChildrenBuilder>.applyTo(component)

        children.map { it.value ?: return }
            .toList()
            .forEach { it.run { component.child(child, index.row, index.column) } }
    }
}
