package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.container.RenderEffectWrapper
import net.minecraft.client.util.math.MatrixStack

open class TransformEffectBuilder(var transform: (MatrixStack) -> Unit = {}) :
    DslBuilder<RenderEffectWrapper.RenderEffect> by
    dslBuilder({ RenderEffectWrapper.RenderEffect.transform(transform) })
