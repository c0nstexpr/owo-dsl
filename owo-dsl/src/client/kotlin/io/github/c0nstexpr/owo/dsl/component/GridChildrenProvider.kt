package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.GridChild

interface GridChildrenProvider : ComponentProvider {
    var children: List<DslBuilder<GridChild>>

    var rows: Int

    var columns: Int
}

fun gridChildrenProvider(): GridChildrenProvider =
    object : GridChildrenProvider, ComponentProvider by componentProvider() {
        override var children = listOf<DslBuilder<GridChild>>()

        override var rows = 0

        override var columns = 0
    }
