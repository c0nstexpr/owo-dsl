package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

class HsvColorBuilder(
    var hue: Float = 0f,
    var saturation: Float = 0f,
    var value: Float = 0f,
    var alpha: Float? = null
) : DslBuilder<Color> by dslBuilder({
        Color.ofHsv(
            hue,
            saturation,
            value,
            alpha ?: return@dslBuilder Color.ofHsv(hue, saturation, value)
        )
    })
