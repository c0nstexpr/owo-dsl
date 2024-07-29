package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

open class RgbIntColorBuilder(var rgb: Int? = null) :
    DslBuilder<Color> by dslBuilder({ rgb?.let(Color::ofRgb) })
