package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning

open class PositioningBuilder : OwoBuilder<Positioning> {
    var x = 0
    var y = 0
    var type: Positioning.Type? = null

    override fun build() = when (type) {
        Positioning.Type.LAYOUT -> Positioning.layout().withX(x).withY(y)
        Positioning.Type.ABSOLUTE -> Positioning.absolute(x, y)
        Positioning.Type.RELATIVE -> Positioning.relative(x, y)
        Positioning.Type.ACROSS -> Positioning.across(x, y)
        else -> null
    }
}
