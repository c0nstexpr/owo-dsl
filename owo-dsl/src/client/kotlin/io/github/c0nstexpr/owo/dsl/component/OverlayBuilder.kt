package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.OverlayContainer
import io.wispforest.owo.ui.core.Component

open class OverlayBuilder<T : Component>(var closeOnClick: Boolean? = null) :
    WrappingParentBuilder<T>() {
    override fun provide() = child.value?.let(Containers::overlay)?.also(::applyTo)

    protected fun applyTo(component: OverlayContainer<T>) {
        super.applyTo(component)
        closeOnClick?.let(component::closeOnClick)
    }
}
