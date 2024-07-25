package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.WrappingParentComponent
import io.wispforest.owo.ui.core.Component

abstract class WrappingParentBuilder<T : Component> : BaseParentComponentBuilder() {
    var child = nullBuilder<T>()

    abstract override fun build(): WrappingParentComponent<T>?
}
