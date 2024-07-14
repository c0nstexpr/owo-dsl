package org.c0nstexpr.owo.dsl.component

class ChildrenScope(private val children: MutableList<ComponentBuilder>) {
    fun ComponentBuilder.scope(i: Int) = children.add(i, this)

    fun ComponentBuilder.scope() = children.add(this)
}
