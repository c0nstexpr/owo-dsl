package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface TextBuilder : DslBuilder<Text>

fun text() = invalidBuilder<Text>()

fun text(block: DslBuilder<Text> = invalidBuilder()): TextBuilder =
    object : TextBuilder, DslBuilder<Text> by block {}

fun text(block: () -> Text?) = text(dslBuilder { block() })

fun DslBuilder<String>.toText() = text { built?.let(Text::of) }
