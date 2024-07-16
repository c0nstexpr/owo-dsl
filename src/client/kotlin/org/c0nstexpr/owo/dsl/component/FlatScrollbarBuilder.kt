package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.ScrollContainer
import io.wispforest.owo.ui.core.Color
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder

interface FlatScrollbarBuilder : ScrollbarBuilder {
    var color: OwoBuilder<Color>

    override fun build() = ScrollContainer.Scrollbar.flat(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun flatScrollbar(crossinline block: FlatScrollbarBuilder.() -> Unit) =
    object : FlatScrollbarBuilder {
        override var color = invalidBuilder<Color>()
    }.apply(block)
