package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.DraggableContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.core.Component

open class DraggableBuilder<T : Component> : WrappingParentBuilder() {
    var direction = invalidBuilder<ScrollDirection>()

    var child = invalidBuilder<T>()

    var foreheadSize = invalidBuilder<Int>()

    override fun build(): DraggableContainer<T>? {
        return Containers.draggable(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null,
            child.built ?: return null
        ).apply(::applyTo)
    }
}

fun <T : Component> DraggableBuilder<T>.applyTo(component: DraggableContainer<T>) {
    (this as WrappingParentBuilder).applyTo(component)

    foreheadSize.built?.let(component::foreheadSize)
}
