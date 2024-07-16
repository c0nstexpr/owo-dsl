package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.RenderEffectWrapper
import net.minecraft.util.math.RotationAxis
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

@Suppress("UnstableApiUsage")
interface RotateEffectBuilder : RenderEffectBuilder {
    var angle: OwoBuilder<Float>

    var axis: OwoBuilder<RotationAxis>

    override fun build() = if (axis.canBuild)
        RenderEffectWrapper.RenderEffect.rotate(
            axis.build(),
            angle.build()
        )!!
    else RenderEffectWrapper.RenderEffect.rotate(angle.build())!!

    override val canBuild get() = angle.canBuild
}

inline fun rotateEffect(crossinline block: RotateEffectBuilder.() -> Unit) =
    object : RotateEffectBuilder {
        override var angle = invalidBuilder<Float>()

        override var axis = invalidBuilder<RotationAxis>()
    }.apply(block)
