package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.StackLayout

open class StackLayoutProvider :
    BaseParentComponentProvider(),
    ListChildrenBuilder by listChildren() {
    override fun provide(): StackLayout? {
        return Containers.stack(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: StackLayout) {
        super.applyTo(component)
        children.map { it.built ?: return }.toList().forEach(component::child)
    }
}
