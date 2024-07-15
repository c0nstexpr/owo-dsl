package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import org.c0nstexpr.owo.dsl.OwoBuilder

open class ChildrenScope(private val children: MutableList<OwoBuilder<Component>>) {
    fun OwoBuilder<Component>.scope(i: Int) = children.add(i, this)

    fun OwoBuilder<Component>.scope() = children.add(this)
}
