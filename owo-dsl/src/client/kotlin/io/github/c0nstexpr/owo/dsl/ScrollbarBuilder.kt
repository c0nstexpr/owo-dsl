package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.container.ScrollContainer.Scrollbar
import org.w3c.dom.Element

interface ScrollbarBuilder : DslBuilder<Scrollbar> {
    companion object {
        fun Element.parseScrollbar() = object : DslBuilder<Scrollbar> by
        dslBuilder({ Scrollbar.parse(this) }) {}
    }
}
