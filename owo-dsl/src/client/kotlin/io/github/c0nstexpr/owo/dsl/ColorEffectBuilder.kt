package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.core.Color

open class ColorEffectBuilder(var color: DslBuilder<Color> = nullBuilder()) :
    DslBuilder<RenderEffectWrapper.RenderEffect> by
    dslBuilder({ color.value?.let(RenderEffectWrapper.RenderEffect::color) })
