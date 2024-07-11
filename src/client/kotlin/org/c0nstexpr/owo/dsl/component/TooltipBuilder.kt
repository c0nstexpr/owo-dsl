package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.tooltip.TooltipComponent
import org.c0nstexpr.owo.dsl.DelegateBuilder
import org.c0nstexpr.owo.dsl.OrderedTextBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.orderedTextOf

interface TooltipBuilder<T : TooltipComponent> : DelegateBuilder<T>

fun TooltipBuilder<TooltipComponent>.text(text: OrderedTextBuilder) {
    value = OwoBuilder {
        TooltipComponent.of(text.build())
    }
}

fun TooltipBuilder<TooltipComponent>.text(text: OwoBuilder<String>) {
    text(orderedTextOf(text))
}
