package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.core.Component

interface ListChildren {
    var children: List<DslBuilder<Component>>
}

fun listChildren() = object : ListChildren {
    override var children = listOf<DslBuilder<Component>>()
}
