package io.github.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.container.ScrollContainer
import io.wispforest.owo.ui.core.Color

open class FlatScrollbarBuilder(var color: DslBuilder<Color> = nullBuilder()) :
    DslBuilder<ScrollContainer.Scrollbar> by
    dslBuilder({ color.value?.let(ScrollContainer.Scrollbar::flat) })
