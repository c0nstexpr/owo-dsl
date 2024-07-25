package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.ScrollContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.container.ScrollContainer.Scrollbar
import io.wispforest.owo.ui.core.Component

open class ScrollerBuilder<T : Component> : WrappingParentBuilder<T>() {
    var direction = nullBuilder<ScrollDirection>()

    var scrollbarThickness = nullBuilder<Int>()

    var scrollbar = nullBuilder<Scrollbar>()

    var scrollStep = nullBuilder<Int>()

    var fixedScrollbarLength = nullBuilder<Int>()

    override fun build(): ScrollContainer<T>? {
        val h = horizontalSizing.built ?: return null
        val v = verticalSizing.built ?: return null
        val c = child.built ?: return null

        return when (direction.built ?: return null) {
            ScrollDirection.VERTICAL -> Containers.verticalScroll(h, v, c)
            ScrollDirection.HORIZONTAL -> Containers.horizontalScroll(h, v, c)
        }.also(::applyTo)
    }
}

fun <T : Component> ScrollerBuilder<T>.applyTo(component: ScrollContainer<T>) {
    (this as WrappingParentBuilder<T>).applyTo(component)

    scrollbarThickness.built?.let(component::scrollbarThiccness)
    scrollbar.built?.let(component::scrollbar)
    scrollStep.built?.let(component::scrollStep)
    fixedScrollbarLength.built?.let(component::fixedScrollbarLength)
}
