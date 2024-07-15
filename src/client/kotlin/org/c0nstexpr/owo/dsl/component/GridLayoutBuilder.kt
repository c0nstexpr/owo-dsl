package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.GridLayout
import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

class GridLayoutBuilder : BaseParentComponentBuilder() {
    var rows = invalidBuilder<Int>()

    var columns = invalidBuilder<Int>()

    var children = mutableListOf<MutableList<OwoBuilder<Component>>>()

    override fun build() = Containers.grid(
        horizontalSizing.build(),
        verticalSizing.build(),
        rows.build(),
        columns.build()
    )!!.apply(::applyTo)

    override val canBuild
        get() = horizontalSizing.canBuild &&
            verticalSizing.canBuild &&
            rows.canBuild &&
            columns.canBuild &&
            children.all { it.all { it.canBuild } }
}

fun GridLayoutBuilder.applyTo(component: GridLayout) {
    require(children.size <= rows.build())

    val columnSize = columns.build()

    children.forEachIndexed { i, row ->
        require(row.size <= columnSize)

        row.forEachIndexed { j, child -> component.child(child.build(), i, j) }
    }
}

inline fun gridLayout(crossinline block: GridLayoutBuilder.() -> Unit) =
    GridLayoutBuilder().apply(block)

inline fun GridLayoutBuilder.children(crossinline block: GridChildrenScope.() -> Unit) {
    GridChildrenScope(children).apply(block)
}
