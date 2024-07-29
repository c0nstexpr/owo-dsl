package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.PositionedRectangle
import io.wispforest.owo.ui.core.Size

typealias PosRect = PositionedRectangle

open class PosRectBuilder(
    var x: Int = 0,
    var y: Int = 0,
    var size: DslBuilder<Size> = nullBuilder()
) : DslBuilder<PositionedRectangle> by
    dslBuilder({ PositionedRectangle.of(x, y, size.built ?: return@dslBuilder null) }) {
    companion object {
        fun DslBuilder<PosRect>.intersection(other: DslBuilder<PosRect>) =
            dslBuilder { built?.intersection(other.built ?: return@dslBuilder null) }
    }
}
