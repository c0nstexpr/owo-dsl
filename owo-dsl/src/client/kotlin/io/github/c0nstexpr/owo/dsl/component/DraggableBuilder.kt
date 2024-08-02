package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.DraggableContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.core.Component

open class DraggableBuilder<T : Component>(
    var direction: DslBuilder<ScrollDirection> = nullBuilder(),
    var foreheadSize: Int? = null
) : WrappingParentBuilder<T>() {
    override fun provide(): DraggableContainer<T>? {
        return Containers.draggable(
            horizontalSizing.value ?: return null,
            verticalSizing.value ?: return null,
            child.value ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: DraggableContainer<T>) {
        super.applyTo(component)
        foreheadSize?.let(component::foreheadSize)
    }
}
