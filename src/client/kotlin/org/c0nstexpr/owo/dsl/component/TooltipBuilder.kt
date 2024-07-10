package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.tooltip.TooltipComponent
import org.c0nstexpr.owo.dsl.OrderedTextBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.orderedTextOf

fun interface TooltipBuilder<T : TooltipComponent> : OwoBuilder<T>

fun tooltipOf(text: OrderedTextBuilder) = TooltipBuilder {
    TooltipComponent.of(text.build() ?: return@TooltipBuilder null)
}

fun tooltipOf(block: () -> String) = tooltipOf(orderedTextOf(block))
