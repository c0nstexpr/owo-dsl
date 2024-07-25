package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.wispforest.owo.ui.core.Component

open class GridRowBuilder(
    val rowIndex: Int,
    private val row: MutableMap<Int, DslBuilder<Component>> = mutableMapOf()
) : DslBuilder<Map<Int, Component>> by
    dslBuilder({ row.mapValues { it.value.built ?: return@dslBuilder null }.toMap() }) {
    fun <T : DslBuilder<Component>> cell(
        column: Int,
        builder: (T.() -> Unit) -> T,
        block: T.() -> Unit
    ) {
        row[column] = builder(block)
    }

    fun <T : DslBuilder<Component>> cell(column: Int, builder: T) {
        cell(column, { builder }) { }
    }
}

inline fun gridRow(rowIndex: Int, crossinline block: GridRowBuilder.() -> Unit) =
    GridRowBuilder(rowIndex).also(block)
