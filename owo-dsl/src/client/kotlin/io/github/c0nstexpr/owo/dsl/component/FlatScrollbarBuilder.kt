package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.canBuild
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.ScrollContainer
import io.wispforest.owo.ui.core.Color

interface FlatScrollbarBuilder : ScrollbarBuilder {
    var color: DslBuilder<Color>

    override fun build() = ScrollContainer.Scrollbar.flat(color.build())!!

    override val canBuild get() = color.canBuild
}

inline fun flatScrollbar(crossinline block: FlatScrollbarBuilder.() -> Unit) =
    object : FlatScrollbarBuilder {
        override var color = invalidBuilder<Color>()
    }.apply(block)
