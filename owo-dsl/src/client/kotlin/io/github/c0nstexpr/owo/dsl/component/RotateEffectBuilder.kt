package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.RenderEffectWrapper
import net.minecraft.util.math.RotationAxis

interface RotateEffectBuilder : RenderEffectBuilder {
    var angle: DslBuilder<Float>

    var axis: DslBuilder<RotationAxis>

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
