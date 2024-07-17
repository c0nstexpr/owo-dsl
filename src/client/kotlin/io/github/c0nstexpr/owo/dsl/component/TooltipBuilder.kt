package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OrderedTextBuilder
import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.github.c0nstexpr.owo.dsl.orderedText
import net.minecraft.client.gui.tooltip.TooltipComponent

interface TooltipBuilder : OwoBuilder<TooltipComponent> {
    var orderedTextBuilder: OrderedTextBuilder

    override fun build() = TooltipComponent.of(orderedTextBuilder.build())!!

    override val canBuild get() = orderedTextBuilder.canBuild
}

inline fun tooltip(crossinline block: TooltipBuilder.() -> Unit) = object : TooltipBuilder {
    override var orderedTextBuilder = orderedText()
}.apply(block)
