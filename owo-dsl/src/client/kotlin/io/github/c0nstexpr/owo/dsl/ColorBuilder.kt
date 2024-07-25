package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Color
import net.minecraft.util.DyeColor
import net.minecraft.util.Formatting
import org.w3c.dom.Node

abstract class ColorBuilder : DslBuilder<Color> {
    companion object {
        fun DslBuilder<Color>.interpolate(next: DslBuilder<Color>, delta: DslBuilder<Float>) =
            dslBuilder {
                built?.interpolate(
                    next.built ?: return@dslBuilder null,
                    delta.built ?: return@dslBuilder null
                )
            }

        fun DslBuilder<DyeColor>.toColor(): ColorBuilder = object :
            ColorBuilder(),
            DslBuilder<Color> by dslBuilder({ built?.let(Color::ofDye) }) {}

        fun DslBuilder<Formatting>.toColor(): ColorBuilder = object :
            ColorBuilder(),
            DslBuilder<Color> by dslBuilder({ built?.let(Color::ofFormatting) }) {}
    }

    class Rgba(
        var red: DslBuilder<Float> = nullBuilder(),
        var green: DslBuilder<Float> = nullBuilder(),
        var blue: DslBuilder<Float> = nullBuilder(),
        var alpha: DslBuilder<Float> = nullBuilder()
    ) : ColorBuilder(),
        DslBuilder<Color> by dslBuilder({
            val r = red.built ?: return@dslBuilder null
            val g = green.built ?: return@dslBuilder null
            val b = blue.built ?: return@dslBuilder null
            val a = alpha.built

            if (a == null) Color(r, g, b) else Color(r, g, b, a)
        })

    class Hsv(
        var hue: DslBuilder<Float> = nullBuilder(),
        var saturation: DslBuilder<Float> = nullBuilder(),
        var value: DslBuilder<Float> = nullBuilder(),
        var alpha: DslBuilder<Float> = nullBuilder()
    ) : ColorBuilder(),
        DslBuilder<Color> by dslBuilder({
            val h = hue.built ?: return@dslBuilder null
            val s = saturation.built ?: return@dslBuilder null
            val v = value.built ?: return@dslBuilder null
            val a = alpha.built

            if (a == null) Color.ofHsv(h, s, v) else Color.ofHsv(h, s, v, a)
        })

    class RgbInt(var rgb: DslBuilder<Int> = nullBuilder()) :
        ColorBuilder(),
        DslBuilder<Color> by dslBuilder({ rgb.built?.let(Color::ofRgb) })

    class Parse(var node: DslBuilder<Node> = nullBuilder()) :
        ColorBuilder(),
        DslBuilder<Color> by dslBuilder({ node.built?.let(Color::parse) })
}
