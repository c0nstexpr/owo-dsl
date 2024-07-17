package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.github.c0nstexpr.owo.dsl.color
import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.core.Color

interface ColorEffectBuilder : RenderEffectBuilder {
    var color: OwoBuilder<Color>

    override fun build() = RenderEffectWrapper.RenderEffect.color(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun colorEffect(crossinline block: ColorEffectBuilder.() -> Unit) =
    object : ColorEffectBuilder {
        override var color: OwoBuilder<Color> = color()
    }.apply(block)
