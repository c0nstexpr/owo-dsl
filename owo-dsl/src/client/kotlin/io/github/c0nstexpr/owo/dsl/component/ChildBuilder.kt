package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.Component

interface ChildBuilder<T : Component> {
    var child: DslBuilder<T>
}

fun <T : Component> childBuilder() = object : ChildBuilder<T> {
    override var child = nullBuilder<T>()
}
