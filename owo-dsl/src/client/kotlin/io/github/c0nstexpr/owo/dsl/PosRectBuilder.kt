package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.PosRectBuilder.Companion.Of
import io.wispforest.owo.ui.core.PositionedRectangle
import io.wispforest.owo.ui.core.Size

typealias PosRect = PositionedRectangle

interface PosRectBuilder : DslBuilder<PosRect> {
    companion object {
        open class Of(
            var x: DslBuilder<Int> = invalidBuilder(),
            var y: DslBuilder<Int> = invalidBuilder(),
            var size: DslBuilder<Size> = size()
        ) : PosRectBuilder,
            DslBuilder<PositionedRectangle> by posRect({
                PositionedRectangle.of(
                    x.built ?: return@posRect null,
                    y.built ?: return@posRect null,
                    size.built ?: return@posRect null
                )
            })

        fun DslBuilder<PosRect>.interpolate(next: DslBuilder<PosRect>, delta: DslBuilder<Float>) =
            dslBuilder {
                built?.interpolate(
                    next.built ?: return@dslBuilder null,
                    delta.built ?: return@dslBuilder null
                )
            }

        fun DslBuilder<PosRect>.intersection(other: DslBuilder<PosRect>) =
            dslBuilder { built?.intersection(other.built ?: return@dslBuilder null) }
    }
}

fun posRect() = invalidBuilder<PosRect>()

fun posRect(block: DslBuilder<PosRect> = invalidBuilder()): PosRectBuilder =
    object : PosRectBuilder, DslBuilder<PosRect> by block {}

fun posRect(block: () -> PosRect?) = posRect(dslBuilder { block() })

inline fun posRectOf(crossinline block: Of.() -> Unit) = Of().apply(block)
