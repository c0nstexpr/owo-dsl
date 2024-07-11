package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.BlockComponent
import io.wispforest.owo.ui.component.Components
import org.c0nstexpr.owo.dsl.BlockResultBuilder

abstract class BlockComponentBuilder<T : BlockComponent> : BaseComponentBuilder<T>() {
    var blockStateBuilder = BlockResultBuilder()

    override val canBuild get() = blockStateBuilder.canBuild
}

inline fun blockComponent(crossinline block: BlockComponentBuilder<BlockComponent>.() -> Unit) =
    object : BlockComponentBuilder<BlockComponent>() {
        override fun build() = blockStateBuilder.build()
            .run { Components.block(blockState(), nbt()) }
    }.apply(block)

inline val BlockComponentBuilder<*>.blockState get() = blockStateBuilder

inline fun BlockComponentBuilder<*>.blockState(crossinline block: BlockResultBuilder.() -> Unit) =
    block(blockStateBuilder)
