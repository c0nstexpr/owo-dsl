package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built

open class PosRectInterpolateBuilder(
    var current: DslBuilder<PosRect> = nullBuilder(),
    var next: DslBuilder<PosRect> = nullBuilder(),
    var delta: Float = 0f
) : DslBuilder<PosRect> by dslBuilder({
        current.built?.interpolate(next.built ?: return@dslBuilder null, delta)
    })
