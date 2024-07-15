package org.c0nstexpr.owo.dsl

import net.minecraft.text.OrderedText

@FunctionalInterface
fun interface OrderedTextBuilder : OwoBuilder<OrderedText>

fun orderedText(block: OwoBuilder<OrderedText> = invalidBuilder()) = object : OrderedTextBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
