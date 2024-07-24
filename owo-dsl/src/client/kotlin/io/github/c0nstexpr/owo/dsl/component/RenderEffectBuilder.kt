package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import io.wispforest.owo.ui.core.Color

interface RenderEffectBuilder : DslBuilder<RenderEffect>

fun renderEffect() = invalidBuilder<RenderEffect>()

fun renderEffect(block: DslBuilder<RenderEffect>): RenderEffectBuilder =
    object : RenderEffectBuilder, DslBuilder<RenderEffect> by block {}

fun renderEffect(block: () -> RenderEffect?) = renderEffect(dslBuilder { block() })

fun colorRenderEffect(block: DslBuilder<Color>) =
    renderEffect { block.built?.let(RenderEffect::color) }
