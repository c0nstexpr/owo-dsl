package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.component.BlockComponent

abstract class BlockComponentProvider(val provider: () -> BlockComponent?) :
    BaseComponentProvider(),
    DslBuilder<BlockComponent> {
    override var cached: BlockComponent? = null
        protected set

    override fun clear() {
        cached = null
    }

    override fun build() {
        if (cached == null) cached = provider()
    }

    override fun provide() = provider()?.apply(::applyTo)

    open fun applyTo(component: BlockComponent) = Unit
}
