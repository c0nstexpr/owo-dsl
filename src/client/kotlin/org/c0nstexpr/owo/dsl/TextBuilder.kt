package org.c0nstexpr.owo.dsl

import net.minecraft.text.Text

interface TextBuilder : OwoBuilder<Text>

fun invalidTextBuilder() = object : TextBuilder {
    override fun build() = throw IllegalStateException("Invalid text builder")

    override val canBuild get() = false
}

inline fun textOf(crossinline block: () -> String) = object : TextBuilder {
    override fun build() = Text.of(block())

    override val canBuild get() = true
}
