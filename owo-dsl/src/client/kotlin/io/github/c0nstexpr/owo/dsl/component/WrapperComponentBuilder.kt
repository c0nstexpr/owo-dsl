package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.Component

interface WrapperComponentBuilder<T : Component> : ComponentBuilder {
    var child: DslBuilder<T>
}

fun <T : Component> wrapperComponent(): WrapperComponentBuilder<T> =
    object : WrapperComponentBuilder<T>, ComponentBuilder by component() {
        override var child = nullBuilder<T>()
    }
