package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.RenderEffectWrapper.RenderEffect
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.RotationAxis
import org.joml.Matrix4f
import io.wispforest.owo.ui.core.Color as McColor

interface RenderEffectBuilder : DslBuilder<RenderEffect> {
    class Rotate(
        var angle: DslBuilder<Float> = nullBuilder(),
        var axis: DslBuilder<RotationAxis> = nullBuilder()
    ) : RenderEffectBuilder,
        DslBuilder<RenderEffect> by dslBuilder({
            val ang = angle.built ?: return@dslBuilder null
            val ax = axis.built ?: return@dslBuilder RenderEffect.rotate(ang)

            RenderEffect.rotate(ax, ang)
        })

    class Color(var color: DslBuilder<McColor> = nullBuilder()) :
        RenderEffectBuilder,
        DslBuilder<RenderEffect> by dslBuilder({ color.built?.let(RenderEffect::color) })

    class Transform(var transform: DslBuilder<(MatrixStack) -> Unit> = nullBuilder()) :
        RenderEffectBuilder,
        DslBuilder<RenderEffect> by
        dslBuilder({ transform.built?.let { RenderEffect.transform(it) } })

    class TransformPos(var transform: DslBuilder<Matrix4f> = nullBuilder()) :
        RenderEffectBuilder,
        DslBuilder<RenderEffect> by
        dslBuilder({ transform.built?.let { RenderEffect.transform(it) } })
}
