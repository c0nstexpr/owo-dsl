package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class RgbIntColorBuilder(var rgb: Int = 0) :
    DslBuilder<Color> by dslBuilder({ Color.ofRgb(rgb) })
