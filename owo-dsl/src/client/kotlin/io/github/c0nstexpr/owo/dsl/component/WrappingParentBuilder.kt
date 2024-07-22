package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.WrappingParentComponent

abstract class WrappingParentBuilder : BaseParentComponentBuilder() {
    abstract override fun build(): WrappingParentComponent<*>
}
