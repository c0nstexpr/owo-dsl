package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.CheckboxComponent
import io.wispforest.owo.ui.component.Components

open class CheckboxBuilder : CheckboxWidgetBuilder() {
    override fun build() = message.built?.let(Components::checkbox)?.also(::applyTo)
}

fun CheckboxBuilder.applyTo(component: CheckboxComponent) {
    (this as CheckboxWidgetBuilder).applyTo(component)

    checked.built?.let(component::checked)
}
