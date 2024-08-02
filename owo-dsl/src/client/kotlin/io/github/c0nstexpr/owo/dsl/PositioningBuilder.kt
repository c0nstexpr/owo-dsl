package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Positioning.Type

open class PositioningBuilder(
    var x: Int? = null,
    var y: Int? = null,
    var type: DslBuilder<Type> = nullBuilder()
) : DslBuilder<Positioning> by dslBuilder({
        val t = type.value ?: return@dslBuilder null

        if (t == Type.LAYOUT) return@dslBuilder Positioning.layout()

        val px = x ?: return@dslBuilder null
        val py = y ?: return@dslBuilder null

        when (t) {
            Type.ABSOLUTE -> Positioning.absolute(px, py)
            Type.RELATIVE -> Positioning.relative(px, py)
            Type.ACROSS -> Positioning.across(px, py)
            else -> null
        }
    })
