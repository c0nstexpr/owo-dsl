package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.ScrollContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.container.ScrollContainer.Scrollbar
import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.invalidBuilder

open class ScrollContainerBuilder<T : Component> : WrappingParentBuilder() {
    var direction = invalidBuilder<ScrollDirection>()

    var child = invalidBuilder<T>()

    var scrollbarThickness = invalidBuilder<Int>()

    var scrollbar = invalidBuilder<Scrollbar>()

    var scrollStep = invalidBuilder<Int>()

    var fixedScrollbarLength = invalidBuilder<Int>()

    override fun build() = when (direction.build()) {
        ScrollDirection.VERTICAL -> Containers.verticalScroll(
            horizontalSizing.build(),
            verticalSizing.build(),
            child.build()
        )!!

        ScrollDirection.HORIZONTAL -> Containers.horizontalScroll(
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

fun <T : Component> ScrollContainerBuilder<T>.applyTo(component: ScrollContainer<T>) {
    (this as WrappingParentBuilder).applyTo(component)

    scrollbarThickness.applyBuild(component::scrollbarThiccness)
    scrollbar.applyBuild(component::scrollbar)
    scrollStep.applyBuild(component::scrollStep)
    fixedScrollbarLength.applyBuild(component::fixedScrollbarLength)
}

inline fun <T : Component> scrollContainer(
    crossinline block: ScrollContainerBuilder<T>.() -> Unit
) = ScrollContainerBuilder<T>().apply(block)
