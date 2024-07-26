package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.GridLayout

open class GridLayoutBuilder :
    BaseParentComponentBuilder(),
    GridChildren by gridChildren() {
    override fun build(): GridLayout? {
        return Containers.grid(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            rows.built ?: return null,
            columns.built ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: GridLayout) {
        super.applyTo(component)

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
}
