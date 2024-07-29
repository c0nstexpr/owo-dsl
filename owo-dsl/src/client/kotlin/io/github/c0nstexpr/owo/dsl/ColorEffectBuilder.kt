package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.core.Color

open class ColorEffectBuilder(var color: DslBuilder<Color> = nullBuilder()) :
    DslBuilder<RenderEffectWrapper.RenderEffect> by
    dslBuilder({ color.built?.let(RenderEffectWrapper.RenderEffect::color) })
