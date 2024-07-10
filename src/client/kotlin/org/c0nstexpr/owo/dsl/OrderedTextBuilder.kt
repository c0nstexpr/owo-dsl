package org.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText

interface OrderedTextBuilder : OwoBuilder<OrderedText>

fun orderedTextOf(txt: TextBuilder) = object : OrderedTextBuilder {
    override fun build() = txt.build().asOrderedText()

    override val canBuild get() = txt.canBuild
}

inline fun orderedTextOf(crossinline block: () -> String) = orderedTextOf(textOf(block))
