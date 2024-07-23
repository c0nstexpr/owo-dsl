package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.PositionedRectangle

open class DefaultPosRectBuilder(
    var x: DslBuilder<Int> = invalidBuilder(),
    var y: DslBuilder<Int> = invalidBuilder(),
    var size: SizeBuilder = size()
) : PosRectBuilder,
    DslBuilder<PositionedRectangle> by posRect(
        {
            x.applyBuilt { x ->
                y.applyBuilt { y -> size.applyBuilt { PositionedRectangle.of(x, y, it) } }
            }
        }
    )

inline fun defaultPosRect(crossinline block: DefaultPosRectBuilder.() -> Unit) =
    DefaultPosRectBuilder().apply(block)
