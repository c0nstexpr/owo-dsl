package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.canBuild
import io.wispforest.owo.ui.core.Component

open class GridRowBuilder(val rowIndex: Int) : DslBuilder<Map<Int, Component>> {
    val row = mutableMapOf<Int, DslBuilder<Component>>()

    override fun build() = row.mapValues { it.value.build() }

    override val canBuild get() = row.all { it.value.canBuild }

    inline fun <T : DslBuilder<Component>> cell(
        column: Int,
        builder: T,
        crossinline block: (Int, T) -> Unit
    ) {
        block(rowIndex, builder)
        row[column] = builder
    }
}

inline fun gridRow(rowIndex: Int, crossinline block: GridRowBuilder.() -> Unit) =
    GridRowBuilder(rowIndex).apply(block)
