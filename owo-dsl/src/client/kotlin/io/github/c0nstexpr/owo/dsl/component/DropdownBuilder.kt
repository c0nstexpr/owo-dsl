package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DropdownComponent

open class DropdownBuilder : FlowLayoutBuilder() {
    var list = nullBuilder<List<DropdownComponent.() -> Unit>>()

    var closeWhenNotHovered = nullBuilder<Boolean>()

    override fun build() = horizontalSizing.built?.let(Components::dropdown)?.also(::applyTo)
}

fun DropdownBuilder.applyTo(component: DropdownComponent) {
    (this as FlowLayoutBuilder).applyTo(component)

    list.built?.forEach { component.it() }
    closeWhenNotHovered.built?.let(component::closeWhenNotHovered)
}
