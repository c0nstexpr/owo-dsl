package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.Text

fun String.toText() = object : DslBuilder<Text> by dslBuilder({ Text.of(this) }) {}
