package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.BlockComponent
import io.wispforest.owo.ui.component.Components
import org.c0nstexpr.owo.dsl.BlockResultBuilder
import org.c0nstexpr.owo.dsl.SurfaceBuilder

abstract class BlockComponentBuilder<T : BlockComponent> : BaseComponentBuilder<T>() {
    var surfaceBuilder = SurfaceBuilder { null }

    var blockStateBuilder = BlockResultBuilder()
}

inline fun blockComponent(crossinline block: BlockComponentBuilder<BlockComponent>.() -> Unit) =
    object : BlockComponentBuilder<BlockComponent>() {
        override fun build(): BlockComponent? {
            val result = blockStateBuilder.build() ?: return null

            return Components.block(result.blockState(), result.nbt())
        }
    }.apply(block)

inline val BlockComponentBuilder<*>.surface get() = surfaceBuilder

inline fun BlockComponentBuilder<*>.surface(crossinline block: SurfaceBuilder.() -> Unit) =
    surfaceBuilder.apply(block)

inline val BlockComponentBuilder<*>.blockState get() = blockStateBuilder

inline fun BlockComponentBuilder<*>.blockState(crossinline block: BlockResultBuilder.() -> Unit) =
    blockStateBuilder.apply(block)
