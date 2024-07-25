package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.GridLayout
import io.wispforest.owo.ui.core.Component

open class GridLayoutBuilder : BaseParentComponentBuilder() {
    var rows = nullBuilder<Int>()

    var columns = nullBuilder<Int>()

    var children = nullBuilder<List<Map<Int, Component>>>()

    override fun build(): GridLayout? {
        return Containers.grid(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            rows.built ?: return null,
            columns.built ?: return null
        ).also(::applyTo)
    }
}

fun GridLayoutBuilder.applyTo(component: GridLayout) {
    (this as BaseParentComponentBuilder).applyTo(component)

    val rowSize = rows.built!!
    val columnSize = columns.built!!

    children.built?.let {
        require(it.size <= rowSize)

        it.forEachIndexed { i, row ->
            require(row.size <= columnSize)

            row.forEach { (j, child) -> component.child(child, i, j) }
        }
    }
}
