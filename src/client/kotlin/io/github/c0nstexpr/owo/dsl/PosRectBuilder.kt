package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.PositionedRectangle

@FunctionalInterface
fun interface PosRectBuilder : OwoBuilder<PositionedRectangle>

fun posRect(block: OwoBuilder<PositionedRectangle> = invalidBuilder()) = object : PosRectBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

fun PosRectBuilder.intersects(other: PosRectBuilder) = object : PosRectBuilder {
    val left = this@intersects

    val right = other

    override fun build() = left.build().intersection(right.build())

    override val canBuild get() = left.canBuild && right.canBuild
}

fun PosRectBuilder.interpolate(other: PosRectBuilder, t: OwoBuilder<Float>) =
    posRect((this as OwoBuilder<PositionedRectangle>).interpolate(other, t))
