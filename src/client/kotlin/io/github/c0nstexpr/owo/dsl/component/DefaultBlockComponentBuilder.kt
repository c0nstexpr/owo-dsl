package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.wispforest.owo.ui.component.BlockComponent

open class DefaultBlockComponentBuilder :
    BlockComponentBuilder(),
    OwoBuilder<BlockComponent> {
    override val canBuild get() = super<BlockComponentBuilder>.canBuild
}

inline fun blockComponent(crossinline block: BlockComponentBuilder.() -> Unit) =
    object : DefaultBlockComponentBuilder() {}.apply(block)
