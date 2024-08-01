package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.WrappingParentComponent
import io.wispforest.owo.ui.core.Component

abstract class WrappingParentProvider<T : Component> :
    BaseParentComponentProvider(),
    WrapperComponentProvider<T> {
    override var child = nullBuilder<T>()

    override fun provide(): WrappingParentComponent<T>? = null
}
