package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.PositioningBuilder.Companion.Type
import io.wispforest.owo.ui.core.Positioning

abstract class PositioningBuilder : DslBuilder<Positioning> {
    companion object {
        class Type(
            var x: DslBuilder<Int> = invalidBuilder(),
            var y: DslBuilder<Int> = invalidBuilder(),
            var type: DslBuilder<Positioning.Type> = invalidBuilder()
        ) : PositioningBuilder(),
            DslBuilder<Positioning> by positioning({
                val px = x.built ?: return@positioning null
                val py = y.built ?: return@positioning null

                when (type.built ?: return@positioning null) {
                    Positioning.Type.LAYOUT -> Positioning.layout().withX(px).withY(py)
                    Positioning.Type.ABSOLUTE -> Positioning.absolute(px, py)
                    Positioning.Type.RELATIVE -> Positioning.relative(px, py)
                    Positioning.Type.ACROSS -> Positioning.across(px, py)
                }
            })
    }
}

fun positioning() = invalidBuilder<Positioning>()

fun positioning(block: DslBuilder<Positioning>): PositioningBuilder =
    object : PositioningBuilder(), DslBuilder<Positioning> by block {}

fun positioning(block: () -> Positioning?) = positioning(dslBuilder { block() })

fun positioningType(block: Type.() -> Unit) = Type().apply(block)
