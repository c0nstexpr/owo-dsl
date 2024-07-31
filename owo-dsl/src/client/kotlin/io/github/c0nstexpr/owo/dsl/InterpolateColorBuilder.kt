package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Color

open class InterpolateColorBuilder(
    var current: DslBuilder<Color> = nullBuilder(),
    var next: DslBuilder<Color> = nullBuilder(),
    var delta: Float = 0f
) : DslBuilder<Color> by
    dslBuilder({ current.built?.interpolate(next.built ?: return@dslBuilder null, delta) })
