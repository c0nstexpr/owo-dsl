package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import org.c0nstexpr.owo.dsl.OwoBuilder

@Suppress("UnstableApiUsage")
@FunctionalInterface
fun interface RenderEffectBuilder : OwoBuilder<RenderEffect>

@Suppress("UnstableApiUsage")
fun renderEffect(block: OwoBuilder<RenderEffect>) = object : RenderEffectBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
