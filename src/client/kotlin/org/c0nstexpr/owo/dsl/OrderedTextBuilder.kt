package org.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText

interface OrderedTextBuilder : DelegateBuilder<OrderedText>

fun orderedTextOf(txt: TextBuilder) = object : OrderedTextBuilder {
    override var value = OwoBuilder {
        txt.build().asOrderedText()
    }
}

fun orderedTextOf(block: OwoBuilder<String>) = orderedTextOf(textOf(block))
