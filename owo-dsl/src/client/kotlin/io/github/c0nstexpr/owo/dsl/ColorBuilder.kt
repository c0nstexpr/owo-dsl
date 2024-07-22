package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

abstract class ColorBuilder : DslBuilder<Color>

fun color(block: DslBuilder<Color> = invalidBuilder()): ColorBuilder =
    object : ColorBuilder(), DslBuilder<Color> by block {}

fun color(block: () -> Color?) = color(dslBuilder { block() })

fun ColorBuilder.interpolate(other: ColorBuilder, value: DslBuilder<Float>) =
    color((this as DslBuilder<Color>).interpolate(other, value))
