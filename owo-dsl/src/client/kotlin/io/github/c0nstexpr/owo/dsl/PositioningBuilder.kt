package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning

abstract class PositioningBuilder : DslBuilder<Positioning>

fun positioning(block: DslBuilder<Positioning> = invalidBuilder()) = object : PositioningBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun positioning(crossinline block: () -> Positioning) = positioning(dslBuilder { block() })
