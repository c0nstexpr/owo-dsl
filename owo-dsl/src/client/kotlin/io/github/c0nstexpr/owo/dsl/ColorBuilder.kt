package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.ColorBuilder.Companion.Hsv
import io.github.c0nstexpr.owo.dsl.ColorBuilder.Companion.Rgba
import io.wispforest.owo.ui.core.Color
import net.minecraft.util.DyeColor
import net.minecraft.util.Formatting
import org.w3c.dom.Node

open class DslBuilderEntrance

abstract class ColorBuilder : DslBuilder<Color> {
    companion object {
        class Rgba(
            var red: DslBuilder<Float> = invalidBuilder(),
            var green: DslBuilder<Float> = invalidBuilder(),
            var blue: DslBuilder<Float> = invalidBuilder(),
            var alpha: DslBuilder<Float> = invalidBuilder()
        ) : ColorBuilder(),
            DslBuilder<Color> by dslBuilder({
                val r = red.built ?: return@dslBuilder null
                val g = green.built ?: return@dslBuilder null
                val b = blue.built ?: return@dslBuilder null
                val a = alpha.built

                if (a == null) Color(r, g, b) else Color(r, g, b, a)
            })

        class Hsv(
            var hue: DslBuilder<Float> = invalidBuilder(),
            var saturation: DslBuilder<Float> = invalidBuilder(),
            var value: DslBuilder<Float> = invalidBuilder(),
            var alpha: DslBuilder<Float> = invalidBuilder()
        ) : ColorBuilder(),
            DslBuilder<Color> by dslBuilder({
                val h = hue.built ?: return@dslBuilder null
                val s = saturation.built ?: return@dslBuilder null
                val v = value.built ?: return@dslBuilder null
                val a = alpha.built

                if (a == null) Color.ofHsv(h, s, v) else Color.ofHsv(h, s, v, a)
            })

        fun DslBuilder<Color>.interpolate(next: DslBuilder<Color>, delta: DslBuilder<Float>) =
            dslBuilder {
                built?.interpolate(
                    next.built ?: return@dslBuilder null,
                    delta.built ?: return@dslBuilder null
                )
            }
    }
}

fun color() = invalidBuilder<Color>()

fun color(block: DslBuilder<Color>): ColorBuilder =
    object : ColorBuilder(), DslBuilder<Color> by block {}

fun color(block: () -> Color?) = color(dslBuilder { block() })

inline fun rgbaColor(crossinline block: Rgba.() -> Unit) = Rgba().apply(block)

inline fun hsvColor(crossinline block: Hsv.() -> Unit) = Hsv().apply(block)

fun rgbIntColor(block: DslBuilder<Int>) = color { block.built?.let(Color::ofRgb) }

fun parseColor(block: DslBuilder<Node>) = color { block.built?.let(Color::parse) }

fun DslBuilder<DyeColor>.toColor(): ColorBuilder =
    object : ColorBuilder(), DslBuilder<Color> by dslBuilder({ built?.let(Color::ofDye) }) {}

fun DslBuilder<Formatting>.toColor(): ColorBuilder =
    object : ColorBuilder(), DslBuilder<Color> by dslBuilder({ built?.let(Color::ofFormatting) }) {}
