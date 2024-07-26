package io.github.c0nstexpr.owo.dsl

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.ScrollContainer.Scrollbar
import io.wispforest.owo.ui.core.Color
import org.w3c.dom.Element

interface ScrollbarBuilder : DslBuilder<Scrollbar> {
    class Flat(var color: DslBuilder<Color> = nullBuilder()) :
        ScrollbarBuilder,
        DslBuilder<Scrollbar> by
        dslBuilder({ color.built?.let(Scrollbar::flat) })

    class Parse(var element: DslBuilder<Element> = nullBuilder()) :
        ScrollbarBuilder,
        DslBuilder<Scrollbar> by
        dslBuilder({ element.built?.let(Scrollbar::parse) })
}
