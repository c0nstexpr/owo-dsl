package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Positioning

abstract class PositioningBuilder : DslBuilder<Positioning> {
    class Type(
        var x: DslBuilder<Int> = nullBuilder(),
        var y: DslBuilder<Int> = nullBuilder(),
        var type: DslBuilder<Positioning.Type> = nullBuilder()
    ) : PositioningBuilder(),
        DslBuilder<Positioning> by dslBuilder({
            val px = x.built ?: return@dslBuilder null
            val py = y.built ?: return@dslBuilder null

            when (type.built ?: return@dslBuilder null) {
                Positioning.Type.LAYOUT -> Positioning.layout().withX(px).withY(py)
                Positioning.Type.ABSOLUTE -> Positioning.absolute(px, py)
                Positioning.Type.RELATIVE -> Positioning.relative(px, py)
                Positioning.Type.ACROSS -> Positioning.across(px, py)
            }
        })
}
