package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.RenderEffectWrapper
import io.wispforest.owo.ui.core.Color
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.color

@Suppress("UnstableApiUsage")
interface ColorEffectBuilder : RenderEffectBuilder {
    var color: OwoBuilder<Color>

    override fun build() = RenderEffectWrapper.RenderEffect.color(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun colorEffect(crossinline block: ColorEffectBuilder.() -> Unit) =
    object : ColorEffectBuilder {
        override var color: OwoBuilder<Color> = color()
    }.apply(block)
