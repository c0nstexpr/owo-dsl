package org.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText

fun interface OrderedTextBuilder : OwoBuilder<OrderedText>

fun orderedTextOf(txt: TextBuilder) = OrderedTextBuilder { txt.build()?.asOrderedText() }

fun orderedTextOf(block: () -> String) = orderedTextOf(textOf(block))
