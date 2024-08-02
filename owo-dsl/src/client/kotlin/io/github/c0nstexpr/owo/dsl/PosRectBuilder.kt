package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.PositionedRectangle
import io.wispforest.owo.ui.core.Size

typealias PosRect = PositionedRectangle

open class PosRectBuilder(
    var x: Int = 0,
    var y: Int = 0,
    var size: DslBuilder<Size> = nullBuilder()
) : DslBuilder<PositionedRectangle> by
    dslBuilder({ PositionedRectangle.of(x, y, size.value ?: return@dslBuilder null) }) {
    companion object {
        fun DslBuilder<PosRect>.intersection(other: DslBuilder<PosRect>) =
            dslBuilder { value?.intersection(other.value ?: return@dslBuilder null) }
    }
}
