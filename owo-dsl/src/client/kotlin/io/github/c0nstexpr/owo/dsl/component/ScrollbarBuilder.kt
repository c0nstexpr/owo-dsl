package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.component.ScrollbarBuilder.Flat
import io.github.c0nstexpr.owo.dsl.dslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
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

fun scrollbar() = nullBuilder<Scrollbar>()

fun scrollbar(block: DslBuilder<Scrollbar>): ScrollbarBuilder = object :
    ScrollbarBuilder, DslBuilder<Scrollbar> by block {}

fun scrollbar(block: () -> Scrollbar?) = scrollbar(dslBuilder { block() })

fun vanillaScrollbar() = scrollbar { Scrollbar.vanilla() }

fun vanillaFlatScrollbar() = scrollbar { Scrollbar.vanillaFlat() }

fun flatScrollbar(block: Flat.() -> Unit) = Flat().also(block)

fun parseScrollbar(block: ScrollbarBuilder.Parse.() -> Unit) = ScrollbarBuilder.Parse().also(block)
