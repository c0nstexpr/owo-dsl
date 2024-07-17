package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect

@FunctionalInterface
fun interface RenderEffectBuilder : OwoBuilder<RenderEffect>

fun renderEffect(block: OwoBuilder<RenderEffect>) = object : RenderEffectBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
