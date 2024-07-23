package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.PositionedRectangle

interface PosRectBuilder : DslBuilder<PositionedRectangle>

fun posRect(block: DslBuilder<PositionedRectangle> = invalidBuilder()): PosRectBuilder =
    object : PosRectBuilder, DslBuilder<PositionedRectangle> by block {}

inline fun posRect(crossinline block: () -> PositionedRectangle?) = posRect(dslBuilder { block() })

fun PosRectBuilder.intersects(other: PosRectBuilder) =
    posRect { applyBuilt { other.applyBuilt(it::intersection) } }

fun PosRectBuilder.interpolate(other: PosRectBuilder, delta: DslBuilder<Float>) = posRect {
    applyBuilt { left ->
        other.applyBuilt { right -> delta.applyBuilt { left.interpolate(right, it) } }
    }
}
