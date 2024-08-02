package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DropdownChild
import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DropdownComponent

open class DropdownBuilder(
    var list: List<DslBuilder<DropdownChild>> = listOf(),
    var closeWhenNotHovered: Boolean? = null
) : FlowLayoutBuilder() {
    override fun provide() = horizontalSizing.value?.let(Components::dropdown)?.also(::applyTo)

    protected fun applyTo(component: DropdownComponent) {
        super.applyTo(component)

        run { list.map { it.value ?: return@run }.toList().forEach { it.applyTo(component) } }
        closeWhenNotHovered?.let(component::closeWhenNotHovered)
    }
}
