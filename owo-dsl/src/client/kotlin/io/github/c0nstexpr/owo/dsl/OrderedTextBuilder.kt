package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.text.OrderedText
import net.minecraft.text.Text

interface OrderedTextBuilder : DslBuilder<OrderedText> {
    companion object {
        fun DslBuilder<Text>.toOrderedText(): OrderedTextBuilder = object :
            OrderedTextBuilder,
            DslBuilder<OrderedText> by dslBuilder({ built?.asOrderedText() }) {}
    }
}
