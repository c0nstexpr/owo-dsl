package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText
import net.minecraft.text.Text

interface OrderedTextBuilder : DslBuilder<OrderedText> {
    companion object {
        fun DslBuilder<Text>.toOrderedText() = object :
            DslBuilder<OrderedText> by dslBuilder({ value?.asOrderedText() }) {}
    }
}
