package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface TextBuilder : DslBuilder<Text> {
    companion object {
        fun String.toText(): TextBuilder =
            object : TextBuilder, DslBuilder<Text> by dslBuilder({ Text.of(this) }) {}
    }
}
