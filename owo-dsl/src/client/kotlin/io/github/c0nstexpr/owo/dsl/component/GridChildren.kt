package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.Component

interface GridChildren {
    var children: DslBuilder<Map<GridIndex, Component>>
    var rows: DslBuilder<Int>
    var columns: DslBuilder<Int>
}

fun gridChildren() = object : GridChildren {
    override var children = nullBuilder<Map<GridIndex, Component>>()
    override var rows = nullBuilder<Int>()
    override var columns = nullBuilder<Int>()
}
