package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.GridChild
import io.wispforest.owo.ui.core.Component

interface GridChildren {
    val children: List<DslBuilder<GridChild<Component>>>

    var rows: Int

    var columns: Int
}

fun gridChildren() = object : GridChildren {
    override var children = mapOf<GridIndex, DslBuilder<Component>>()
        private set

    override var rows = 0

    override var columns = 0
}
