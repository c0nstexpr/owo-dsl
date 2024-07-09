package org.c0nstexpr.owo.dsl

import net.minecraft.client.gui.tooltip.TooltipComponent

interface TooltipBuilder : OwoBuilder<TooltipComponent>

fun tooltipOf(text: OrderedTextBuilder) = object : TooltipBuilder {
    override fun build(): TooltipComponent? {
        return TooltipComponent.of(text.build() ?: return null)
    }
}

fun tooltipOf(block: () -> String) = tooltipOf(orderedTextOf(block))
