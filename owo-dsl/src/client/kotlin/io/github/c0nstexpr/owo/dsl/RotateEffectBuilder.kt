package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import net.minecraft.util.math.RotationAxis

open class RotateEffectBuilder(
    var angle: Float = 0f,
    var axis: DslBuilder<RotationAxis> = nullBuilder()
) : DslBuilder<RenderEffect> by dslBuilder({
        RenderEffect.rotate(axis.built ?: return@dslBuilder RenderEffect.rotate(angle), angle)
    })
