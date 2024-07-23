package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning

abstract class PositioningBuilder : DslBuilder<Positioning>

fun positioning(block: DslBuilder<Positioning> = invalidBuilder()): PositioningBuilder =
    object : PositioningBuilder(), DslBuilder<Positioning> by block {}

inline fun positioning(crossinline block: () -> Positioning?) = positioning(dslBuilder { block() })
