package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color

abstract class ColorBuilder : DslBuilder<Color>

fun color(block: DslBuilder<Color> = invalidBuilder()) = object : ColorBuilder() {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

fun ColorBuilder.interpolate(other: ColorBuilder, value: DslBuilder<Float>) =
    color((this as DslBuilder<Color>).interpolate(other, value))
