package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

abstract class ColorBuilder : OwoBuilder<Color>

fun color(block: OwoBuilder<Color> = invalidBuilder()) = object : ColorBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

fun ColorBuilder.interpolate(other: ColorBuilder, value: OwoBuilder<Float>) =
    color((this as OwoBuilder<Color>).interpolate(other, value))
