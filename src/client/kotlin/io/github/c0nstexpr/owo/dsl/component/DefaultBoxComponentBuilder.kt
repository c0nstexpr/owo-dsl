package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.wispforest.owo.ui.component.BoxComponent

open class DefaultBoxComponentBuilder :
    BoxComponentBuilder(),
    OwoBuilder<BoxComponent> {
    override val canBuild get() = super<BoxComponentBuilder>.canBuild
}

inline fun box(crossinline block: BoxComponentBuilder.() -> Unit) =
    BoxComponentBuilder().apply(block)
