package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder

open class GridRowBuilder(val rowIndex: Int) : OwoBuilder<Map<Int, Component>> {
    val row = mutableMapOf<Int, OwoBuilder<Component>>()

    override fun build() = row.mapValues { it.value.build() }

    override val canBuild get() = row.all { it.value.canBuild }

    inline fun <T : OwoBuilder<Component>> cell(
        column: Int,
        crossinline provider: () -> T,
        crossinline block: (Int, T) -> Unit
    ) {
        val builder = provider()
        block(rowIndex, builder)
        row[column] = builder
    }
}

inline fun gridRow(rowIndex: Int, crossinline block: GridRowBuilder.() -> Unit) =
    GridRowBuilder(rowIndex).apply(block)
