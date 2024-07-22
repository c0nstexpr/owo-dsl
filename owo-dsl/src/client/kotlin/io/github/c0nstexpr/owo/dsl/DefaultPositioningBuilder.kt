package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning

open class DefaultPositioningBuilder : PositioningBuilder() {
    var x = invalidBuilder<Int>()
    var y = invalidBuilder<Int>()
    var type = invalidBuilder<Positioning.Type>()

    override fun build(): Positioning {
        val px = x.build()
        val py = y.build()

        return when (type.build()) {
            Positioning.Type.LAYOUT -> Positioning.layout().withX(px).withY(py)
            Positioning.Type.ABSOLUTE -> Positioning.absolute(px, py)
            Positioning.Type.RELATIVE -> Positioning.relative(px, py)
            Positioning.Type.ACROSS -> Positioning.across(px, py)
        }
    }

    override val canBuild get() = x.canBuild && y.canBuild && type.canBuild
}

inline fun defaultPositioning(crossinline block: DefaultPositioningBuilder.() -> Unit) =
    DefaultPositioningBuilder().apply(block)
