package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.blockResult
import io.wispforest.owo.ui.component.Components

open class BlockComponentBuilder : BaseComponentBuilder() {
    var blockResult = blockResult()

    override val canBuild get() = blockResult.canBuild

    override fun build() =
        blockResult.build().run { Components.block(blockState(), nbt())!! }.apply(::applyTo)
}

inline fun blockComponent(crossinline block: BlockComponentBuilder.() -> Unit) =
    object : BlockComponentBuilder() {}.apply(block)
