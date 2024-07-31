package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.CheckboxComponent
import io.wispforest.owo.ui.component.Components

open class CheckboxBuilder : CheckboxWidgetBuilder() {
    override fun buildComponent() = message.built?.let(Components::checkbox)?.also(::applyTo)

    protected fun applyTo(component: CheckboxComponent) {
        super.applyTo(component)
        component.checked(checked)
    }
}
