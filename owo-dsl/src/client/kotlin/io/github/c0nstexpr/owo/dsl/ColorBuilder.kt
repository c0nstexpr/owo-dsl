package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.Color
import net.minecraft.util.DyeColor
import net.minecraft.util.Formatting
import org.w3c.dom.Node

open class ColorBuilder(
    var red: Float = 0f,
    var green: Float = 0f,
    var blue: Float = 0f,
    var alpha: Float? = null
) : DslBuilder<Color> by dslBuilder({
        Color(red, green, blue, alpha ?: return@dslBuilder Color(red, green, blue))
    }) {
    companion object {
        fun DslBuilder<DyeColor>.toColor() = object :
            DslBuilder<Color> by dslBuilder({ built?.let(Color::ofDye) }) {}

        fun DslBuilder<Formatting>.toColor() = object :
            DslBuilder<Color> by dslBuilder({ built?.let(Color::ofFormatting) }) {}

        fun DslBuilder<Node>.parseColor() = object :
            DslBuilder<Color> by dslBuilder({ built?.let(Color::parse) }) {}
    }
}
