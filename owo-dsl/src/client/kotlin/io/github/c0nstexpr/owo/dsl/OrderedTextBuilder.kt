package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText
import net.minecraft.text.Text

interface OrderedTextBuilder : DslBuilder<OrderedText>

fun orderedText() = invalidBuilder<OrderedText>()

fun orderedText(block: DslBuilder<OrderedText>): OrderedTextBuilder =
    object : OrderedTextBuilder, DslBuilder<OrderedText> by block {}

fun orderedText(block: () -> OrderedText?) = orderedText(dslBuilder { block() })

fun DslBuilder<Text>.toOrderedText() = orderedText { built?.asOrderedText() }
