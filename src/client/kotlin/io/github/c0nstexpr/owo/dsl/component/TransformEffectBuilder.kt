package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.RenderEffectWrapper
import net.minecraft.client.util.math.MatrixStack
import org.joml.Matrix4f
import java.util.function.Consumer

interface TransformEffectBuilder : RenderEffectBuilder {
    var transform: OwoBuilder<Consumer<MatrixStack>>

    override fun build() = RenderEffectWrapper.RenderEffect.transform(transform.build())!!

    override val canBuild get() = transform.canBuild
}

inline fun transformEffect(crossinline block: TransformEffectBuilder.() -> Unit) =
    object : TransformEffectBuilder {
        override var transform = invalidBuilder<Consumer<MatrixStack>>()
    }.apply(block)

fun TransformEffectBuilder.byMulPos(trans: OwoBuilder<Matrix4f>) {
    transform = object : OwoBuilder<Consumer<MatrixStack>> {
        override fun build() = trans.build().let {
            Consumer<MatrixStack> { matrices ->
                matrices.multiplyPositionMatrix(it)
            }
        }

        override val canBuild get() = trans.canBuild
    }
}
