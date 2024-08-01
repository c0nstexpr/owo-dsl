package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.core.Component

interface ListChildrenProvider {
    var children: List<DslBuilder<Component>>
}

fun listChildrenProvider() = object : ListChildrenProvider {
    override var children = listOf<DslBuilder<Component>>()
}
