package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder

open class GridChildrenScope(
    private val columns: OwoBuilder<Int>,
    children: MutableList<OwoBuilder<Component>>
) : ChildrenScope(children) {
    fun OwoBuilder<Component>.scope(row: Int, column: Int) {
        OwoBuilder {
        }

        scope(row * columns + column)
    }
}
