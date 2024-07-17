package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.GridLayout
import io.wispforest.owo.ui.core.Component

class GridLayoutBuilder : BaseParentComponentBuilder() {
    var rows = invalidBuilder<Int>()

    var columns = invalidBuilder<Int>()

    val columnSize by lazy { columns.build() }

    var children = invalidBuilder<List<Map<Int, Component>>>()

    override fun build() = Containers.grid(
        horizontalSizing.build(),
        verticalSizing.build(),
        rows.build(),
        columnSize
    )!!.apply(::applyTo)

    override val canBuild
        get() = horizontalSizing.canBuild &&
            verticalSizing.canBuild &&
            rows.canBuild &&
            columns.canBuild &&
            children.canBuild
}

fun GridLayoutBuilder.applyTo(component: GridLayout) {
    (this as BaseParentComponentBuilder).applyTo(component)

    children.applyBuild {
        require(it.size <= rows.build())

        it.forEachIndexed { i, row ->
            require(row.size <= columnSize)

            row.forEach { (j, child) -> component.child(child, i, j) }
        }
    }
}

inline fun gridLayout(crossinline block: GridLayoutBuilder.() -> Unit) =
    GridLayoutBuilder().apply(block)
