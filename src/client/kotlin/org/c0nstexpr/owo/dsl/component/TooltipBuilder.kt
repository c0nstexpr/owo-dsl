package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.tooltip.TooltipComponent
import org.c0nstexpr.owo.dsl.OrderedTextBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.builder
import org.c0nstexpr.owo.dsl.orderedTextOf

interface TooltipBuilder<T : TooltipComponent> : OwoBuilder<T> {
    var tip: OwoBuilder<T>

    override val canBuild get() = tip.canBuild

    override fun build() = tip.build()
}

fun TooltipBuilder<TooltipComponent>.text(text: OrderedTextBuilder) {
    tip = builder { TooltipComponent.of(text.build()) }
}

fun TooltipBuilder<TooltipComponent>.text(text: OwoBuilder<String>) {
    text(orderedTextOf(text))
}
