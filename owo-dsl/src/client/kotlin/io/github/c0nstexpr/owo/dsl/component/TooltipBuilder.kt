package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import net.minecraft.client.gui.tooltip.TooltipComponent
import net.minecraft.text.OrderedText

interface TooltipBuilder : DslBuilder<TooltipComponent> {
    companion object {
        fun DslBuilder<OrderedText>.toTooltip() = tooltip {
            built?.let(TooltipComponent::of)
        }
    }
}

fun tooltip() = nullBuilder<TooltipComponent>()

fun tooltip(block: DslBuilder<TooltipComponent>): TooltipBuilder =
    object : TooltipBuilder, DslBuilder<TooltipComponent> by block {}

fun tooltip(block: () -> TooltipComponent?) = tooltip(dslBuilder(block))
