package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.PositionedRectangle
import io.wispforest.owo.ui.core.Size

typealias PosRect = PositionedRectangle

interface PosRectBuilder : DslBuilder<PosRect> {
    companion object {
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

    open class Of(
        var x: DslBuilder<Int> = nullBuilder(),
        var y: DslBuilder<Int> = nullBuilder(),
        var size: DslBuilder<Size> = nullBuilder()
    ) : PosRectBuilder,
        DslBuilder<PositionedRectangle> by dslBuilder({
            PositionedRectangle.of(
                x.built ?: return@dslBuilder null,
                y.built ?: return@dslBuilder null,
                size.built ?: return@dslBuilder null
            )
        })
}
