package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.container.RenderEffectWrapper
import org.joml.Matrix4f

open class TransformPosEffectBuilder(var transform: DslBuilder<Matrix4f> = nullBuilder()) :
    DslBuilder<RenderEffectWrapper.RenderEffect> by
    dslBuilder({ transform.value?.let { RenderEffectWrapper.RenderEffect.transform(it) } })
