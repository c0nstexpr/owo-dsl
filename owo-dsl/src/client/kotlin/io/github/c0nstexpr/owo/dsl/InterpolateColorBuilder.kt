package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class InterpolateColorBuilder(
    var current: DslBuilder<Color> = nullBuilder(),
    var next: DslBuilder<Color> = nullBuilder(),
    var delta: Float = 0f
) : DslBuilder<Color> by
    dslBuilder({ current.value?.interpolate(next.value ?: return@dslBuilder null, delta) })
