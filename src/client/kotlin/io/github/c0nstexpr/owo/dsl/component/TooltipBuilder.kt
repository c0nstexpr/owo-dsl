package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.OrderedTextBuilder
import net.minecraft.client.gui.tooltip.TooltipComponent

interface TooltipBuilder : DslBuilder<TooltipComponent> {
    var orderedTextBuilder: OrderedTextBuilder

    override fun build() = TooltipComponent.of(orderedTextBuilder.build())!!

    override val canBuild get() = orderedTextBuilder.canBuild
}
