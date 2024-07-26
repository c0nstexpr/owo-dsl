package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.WrappingParentComponent
import io.wispforest.owo.ui.core.Component

abstract class WrappingParentBuilder<T : Component> :
    BaseParentComponentBuilder(),
    ChildBuilder<T> by childBuilder<T>() {
    abstract override fun build(): WrappingParentComponent<T>?
}
