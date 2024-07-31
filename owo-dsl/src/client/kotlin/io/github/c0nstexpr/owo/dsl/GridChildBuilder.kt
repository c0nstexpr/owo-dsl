package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Component

open class GridChildBuilder(
    var index: GridIndex = GridIndex(0, 0),
    var child: DslBuilder<Component> = nullBuilder()
) : DslBuilder<GridChild> by dslBuilder({ child.built?.let { GridChild(index, it) } }) {
    var row
        get() = index.row
        set(value) {
            index = index.copy(row = value)
        }

    var column
        get() = index.column
        set(value) {
            index = index.copy(column = value)
        }
}
