package io.github.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText

@FunctionalInterface
fun interface OrderedTextBuilder : DslBuilder<OrderedText>

fun orderedText(block: DslBuilder<OrderedText> = invalidBuilder()) = object : OrderedTextBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

inline fun orderedText(crossinline block: () -> OrderedText) = orderedText(dslBuilder { block() })
