package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.ScrollContainer
import io.wispforest.owo.ui.container.ScrollContainer.ScrollDirection
import io.wispforest.owo.ui.container.ScrollContainer.Scrollbar
import io.wispforest.owo.ui.core.Component

open class ScrollerBuilder<T : Component>(
    var direction: DslBuilder<ScrollDirection> = nullBuilder(),
    var scrollbarThickness: Int? = null,
    var scrollbar: DslBuilder<Scrollbar> = nullBuilder(),
    var scrollStep: Int? = null,
    var fixedScrollbarLength: Int? = null
) : WrappingParentBuilder<T>() {
    override fun provide(): ScrollContainer<T>? {
        val h = horizontalSizing.value ?: return null
        val v = verticalSizing.value ?: return null
        val c = child.value ?: return null

        return when (direction.value ?: return null) {
            ScrollDirection.VERTICAL -> Containers.verticalScroll(h, v, c)
            ScrollDirection.HORIZONTAL -> Containers.horizontalScroll(h, v, c)
        }.also(::applyTo)
    }

    protected fun applyTo(component: ScrollContainer<T>) {
        super.applyTo(component)
        scrollbarThickness?.let(component::scrollbarThiccness)
        scrollbar.value?.let(component::scrollbar)
        scrollStep?.let(component::scrollStep)
        fixedScrollbarLength?.let(component::fixedScrollbarLength)
    }
}
