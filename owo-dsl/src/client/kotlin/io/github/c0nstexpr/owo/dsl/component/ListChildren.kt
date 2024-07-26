package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.Component

interface ListChildren {
    var children: DslBuilder<List<Component>>
}

fun listChildren() = object : ListChildren {
    override var children = nullBuilder<List<Component>>()
}
