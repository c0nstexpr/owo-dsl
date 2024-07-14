package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.tooltip.TooltipComponent
import org.c0nstexpr.owo.dsl.OrderedTextBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.orderedText

interface TooltipBuilder : OwoBuilder<TooltipComponent> {
    var orderedTextBuilder: OrderedTextBuilder

    override fun build() = TooltipComponent.of(orderedTextBuilder.build())!!

    override val canBuild get() = orderedTextBuilder.canBuild
}

inline fun tooltip(crossinline block: TooltipBuilder.() -> Unit) = object : TooltipBuilder {
    override var orderedTextBuilder = orderedText()
}.apply(block)
