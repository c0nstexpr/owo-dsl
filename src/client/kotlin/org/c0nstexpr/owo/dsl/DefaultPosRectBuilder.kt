package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.PositionedRectangle

interface DefaultPosRectBuilder : PosRectBuilder {
    var x: OwoBuilder<Int>

    var y: OwoBuilder<Int>

    var size: SizeBuilder

    override fun build(): PositionedRectangle =
        PositionedRectangle.of(x.build(), y.build(), size.build())

    override val canBuild get() = x.canBuild && y.canBuild && size.canBuild
}

inline fun defaultPosRectBuilder(crossinline block: DefaultPosRectBuilder.() -> Unit) =
    object : DefaultPosRectBuilder {
        override var x = invalidBuilder<Int>()

        override var y = invalidBuilder<Int>()

        override var size = size()
    }.apply(block)
