package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.DraggableContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.core.Component

open class DraggableBuilder<T : Component> : WrappingParentBuilder() {
    var direction = invalidBuilder<ScrollDirection>()

    var child = invalidBuilder<T>()

    var foreheadSize = invalidBuilder<Int>()

    override fun build() = when (direction.build()) {
        ScrollDirection.VERTICAL -> Containers.draggable(
            horizontalSizing.build(),
            verticalSizing.build(),
            child.build()
        )!!

        ScrollDirection.HORIZONTAL -> Containers.draggable(
            horizontalSizing.build(),
            verticalSizing.build(),
            child.build()
        )!!
    }.apply(::applyTo)

    override val canBuild
        get() = horizontalSizing.canBuild &&
            verticalSizing.canBuild &&
            direction.canBuild &&
            child.canBuild
}

fun <T : Component> DraggableBuilder<T>.applyTo(component: DraggableContainer<T>) {
    (this as WrappingParentBuilder).applyTo(component)

    foreheadSize.applyBuild(component::foreheadSize)
}

inline fun <T : Component> draggable(crossinline block: DraggableBuilder<T>.() -> Unit) =
    DraggableBuilder<T>().apply(block)
