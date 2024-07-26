package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.DraggableContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.core.Component

open class DraggableBuilder<T : Component> : WrappingParentBuilder<T>() {
    var direction = nullBuilder<ScrollDirection>()

    var foreheadSize = nullBuilder<Int>()

    override fun build(): DraggableContainer<T>? {
        return Containers.draggable(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            child.built ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: DraggableContainer<T>) {
        super.applyTo(component)
        foreheadSize.built?.let(component::foreheadSize)
    }
}
