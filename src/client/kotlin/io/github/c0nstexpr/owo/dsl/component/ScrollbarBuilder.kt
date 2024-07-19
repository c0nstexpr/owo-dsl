package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.wispforest.owo.ui.container.ScrollContainer.Scrollbar

@FunctionalInterface
fun interface ScrollbarBuilder : DslBuilder<Scrollbar>

fun scrollbar(block: DslBuilder<Scrollbar> = invalidBuilder()) = object :
    ScrollbarBuilder {
    override fun build() = block.build()

    override val canBuild get() = block.canBuild
}

fun vanillaScrollbar() = scrollbar { Scrollbar.vanilla() }

fun vanillaFlatScrollbar() = scrollbar { Scrollbar.vanillaFlat() }
