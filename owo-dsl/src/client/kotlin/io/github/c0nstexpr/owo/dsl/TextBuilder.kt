package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.text.Text

interface TextBuilder : DslBuilder<Text> {
    companion object {
        fun DslBuilder<String>.toText(): TextBuilder =
            object : TextBuilder, DslBuilder<Text> by dslBuilder({ built?.let(Text::of) }) {}
    }
}
