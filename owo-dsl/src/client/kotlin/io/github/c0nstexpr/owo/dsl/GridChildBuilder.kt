package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Component

open class GridChildBuilder(
    var index: GridIndex = GridIndex(0, 0),
    var child: DslBuilder<Component> = nullBuilder()
) : DslBuilder<GridChild> by dslBuilder({ child.value?.let { GridChild(index, it) } }) {
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
