package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.PositionedRectangle

@FunctionalInterface
fun interface PosRectBuilder : DslBuilder<PositionedRectangle>

fun posRect(block: DslBuilder<PositionedRectangle> = invalidBuilder()) = object : PosRectBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun posRect(crossinline block: () -> PositionedRectangle) = posRect(dslBuilder { block() })

fun PosRectBuilder.intersects(other: PosRectBuilder) = object : PosRectBuilder {
    val left = this@intersects

    val right = other

    override fun build() = left.build().intersection(right.build())

    override val canBuild get() = left.canBuild && right.canBuild
}

fun PosRectBuilder.interpolate(other: PosRectBuilder, t: DslBuilder<Float>) =
    posRect((this as DslBuilder<PositionedRectangle>).interpolate(other, t))
