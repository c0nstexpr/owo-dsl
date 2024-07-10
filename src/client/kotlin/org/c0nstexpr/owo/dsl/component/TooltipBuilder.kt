package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.tooltip.TooltipComponent
import org.c0nstexpr.owo.dsl.OrderedTextBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.orderedTextOf

interface TooltipBuilder<T : TooltipComponent> : OwoBuilder<T>

fun tooltipOf(text: OrderedTextBuilder) = object : TooltipBuilder<TooltipComponent> {
    override fun build() = TooltipComponent.of(text.build())

    override val canBuild get() = text.canBuild
}

inline fun tooltipOf(crossinline block: () -> String) = tooltipOf(orderedTextOf(block))
