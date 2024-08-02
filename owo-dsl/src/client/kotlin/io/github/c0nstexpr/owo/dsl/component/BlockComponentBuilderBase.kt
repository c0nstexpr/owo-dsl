package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.component.BlockComponent

abstract class BlockComponentBuilderBase :
    BaseComponentBuilder(),
    DslBuilder<BlockComponent> {
    protected abstract fun build(): BlockComponent?

    final override var value: BlockComponent? = null
        get() {
            if (field == null) field = build()?.apply(::configure)

            return field
        }
        private set

    override fun clear() {
        value = null
    }
}
