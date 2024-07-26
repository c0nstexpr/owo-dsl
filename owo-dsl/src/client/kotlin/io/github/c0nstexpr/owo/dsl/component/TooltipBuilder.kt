package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import net.minecraft.client.gui.tooltip.TooltipComponent
import net.minecraft.text.OrderedText

interface TooltipBuilder : DslBuilder<TooltipComponent> {
    companion object {
        fun DslBuilder<OrderedText>.toTooltip(): TooltipBuilder = object :
            TooltipBuilder,
            DslBuilder<TooltipComponent> by dslBuilder({ built?.let(TooltipComponent::of) }) {}
    }
}
