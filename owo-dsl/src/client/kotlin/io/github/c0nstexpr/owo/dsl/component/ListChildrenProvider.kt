package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.core.Component

interface ListChildrenBuilder : ComponentBuilder {
    var children: List<DslBuilder<Component>>
}

fun listChildrenBuilder(): ListChildrenBuilder =
    object : ListChildrenBuilder, ComponentBuilder by componentBuilder() {
        override var children = listOf<DslBuilder<Component>>()
    }
