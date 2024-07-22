package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.canBuild
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect

@FunctionalInterface
fun interface RenderEffectBuilder : DslBuilder<RenderEffect>

fun renderEffect(block: DslBuilder<RenderEffect>) = object : RenderEffectBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}
