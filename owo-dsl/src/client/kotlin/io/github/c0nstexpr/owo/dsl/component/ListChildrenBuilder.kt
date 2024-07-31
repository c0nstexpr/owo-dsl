package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.core.Component

interface ListChildrenBuilder {
    var children: List<DslBuilder<Component>>
}

fun listChildren() = object : ListChildrenBuilder {
    override var children = listOf<DslBuilder<Component>>()
}
