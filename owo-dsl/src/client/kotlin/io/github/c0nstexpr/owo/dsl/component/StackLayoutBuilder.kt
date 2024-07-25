package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.StackLayout
import io.wispforest.owo.ui.core.Component

open class StackLayoutBuilder : BaseParentComponentBuilder() {
    var children = nullBuilder<List<Component>>()

    override fun build(): StackLayout? {
        return Containers.stack(
            horizontalSizing.built ?: return null,
            verticalSizing.built ?: return null
        ).also(::applyTo)
    }
}

fun StackLayoutBuilder.applyTo(component: StackLayout) {
    (this as BaseParentComponentBuilder).applyTo(component)

    children.built?.forEach(component::child)
}
