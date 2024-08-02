package io.github.c0nstexpr.owo.dsl

open class PosRectInterpolateBuilder(
    var current: DslBuilder<PosRect> = nullBuilder(),
    var next: DslBuilder<PosRect> = nullBuilder(),
    var delta: Float = 0f
) : DslBuilder<PosRect> by dslBuilder({
        current.value?.interpolate(next.value ?: return@dslBuilder null, delta)
    })
