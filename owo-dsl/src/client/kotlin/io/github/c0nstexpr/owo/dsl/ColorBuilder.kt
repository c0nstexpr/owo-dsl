package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Color
import net.minecraft.util.DyeColor

open class DslBuilderEntrance

abstract class ColorBuilder : DslBuilder<Color> {
    open class Entrance :
        ColorBuilder(),
        DslBuilder<Color> by invalidBuilder() {
        fun by(block: DslBuilder<Color>): ColorBuilder =
            object : ColorBuilder(), DslBuilder<Color> by block {}

        fun by(block: () -> Color?) = by(dslBuilder { block() })

        fun argb(value: DslBuilder<Int>) = by { value.applyBuilt(Color::ofArgb) }

        fun rgb(red: DslBuilder<Float>, green: DslBuilder<Float>, blue: DslBuilder<Float>) = by {
            val r = red.built ?: return@by null
            val g = green.built ?: return@by null
            val b = blue.built ?: return@by null

            Color(r, g, b)
        }

        fun dye(dye: DslBuilder<DyeColor>) = by { dye.applyBuilt(Color::ofDye) }
    }
}

fun <R> color(block: ColorBuilder.Entrance.() -> R) = ColorBuilder.Entrance().block()

fun ColorBuilder.interpolate(other: ColorBuilder, value: DslBuilder<Float>) =
    color { by((this@interpolate as DslBuilder<Color>).interpolate(other, value)) }
