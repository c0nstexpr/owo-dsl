package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.component.RenderEffectBuilder.Color
import io.github.c0nstexpr.owo.dsl.component.RenderEffectBuilder.Rotate
import io.github.c0nstexpr.owo.dsl.component.RenderEffectBuilder.Transform
import io.github.c0nstexpr.owo.dsl.component.RenderEffectBuilder.TransformPos
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
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

fun renderEffect() = nullBuilder<RenderEffect>()

fun renderEffect(block: DslBuilder<RenderEffect>): RenderEffectBuilder =
    object : RenderEffectBuilder, DslBuilder<RenderEffect> by block {}

fun renderEffect(block: () -> RenderEffect?) = renderEffect(dslBuilder { block() })

inline fun rotateEffect(crossinline block: Rotate.() -> Unit) = Rotate().also(block)

inline fun colorRenderEffect(crossinline block: Color.() -> Unit) = Color().also(block)

inline fun transformRenderEffect(crossinline block: Transform.() -> Unit) = Transform().also(block)

inline fun transformPosRenderEffect(crossinline block: TransformPos.() -> Unit) =
    TransformPos().also(block)
