package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.StackLayout

open class StackLayoutBuilder :
    BaseParentComponentBuilder(),
    ListChildrenBuilder by listChildrenBuilder() {
    override fun provide(): StackLayout? {
        return Containers.stack(
            horizontalSizing.value ?: return null,
            verticalSizing.value ?: return null
        ).also(::applyTo)
    }

    protected fun applyTo(component: StackLayout) {
        super.applyTo(component)
        children.map { it.value ?: return }.toList().forEach(component::child)
    }
}
