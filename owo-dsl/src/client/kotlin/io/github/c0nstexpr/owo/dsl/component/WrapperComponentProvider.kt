package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.Component

interface WrapperComponentProvider<T : Component> : ComponentProvider {
    var child: DslBuilder<T>
}

fun <T : Component> wrapperComponentProvider(): WrapperComponentProvider<T> =
    object : WrapperComponentProvider<T>, ComponentProvider by componentProvider() {
        override var child = nullBuilder<T>()
    }
