package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning

abstract class PositioningBuilder : OwoBuilder<Positioning>

fun positioning(block: OwoBuilder<Positioning> = invalidBuilder()) = object : PositioningBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
