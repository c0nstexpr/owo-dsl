package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.StackLayout

open class StackLayoutBuilder :
    BaseParentComponentBuilder(),
    ListChildren by listChildren() {
    override fun build(): StackLayout? {
        return Containers.stack(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: StackLayout) {
        super.applyTo(component)
        children.built?.forEach(component::child)
    }
}
