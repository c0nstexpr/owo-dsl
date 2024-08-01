package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DropdownChild
import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.DropdownComponent

open class DropdownProvider(
    var list: List<DslBuilder<DropdownChild>> = listOf(),
    var closeWhenNotHovered: Boolean? = null
) : FlowLayoutProvider() {
    override fun provide() = horizontalSizing.built?.let(Components::dropdown)?.also(::applyTo)

    protected fun applyTo(component: DropdownComponent) {
        super.applyTo(component)

        run { list.map { it.built ?: return@run }.toList().forEach { it.applyTo(component) } }
        closeWhenNotHovered?.let(component::closeWhenNotHovered)
    }
}
