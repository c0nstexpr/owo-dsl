package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.OverlayContainer
import io.wispforest.owo.ui.core.Component

open class OverlayBuilder<T : Component> : WrappingParentBuilder<T>() {
    var closeOnClick = nullBuilder<Boolean>()

    override fun build() = child.built?.let(Containers::overlay)?.also(::applyTo)
}

fun <T : Component> OverlayBuilder<T>.applyTo(component: OverlayContainer<T>) {
    (this as WrappingParentBuilder<T>).applyTo(component)

    closeOnClick.built?.let(component::closeOnClick)
}
