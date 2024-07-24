package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import io.wispforest.owo.ui.component.CheckboxComponent
import io.wispforest.owo.ui.component.Components

open class CheckboxBuilder : CheckboxWidgetBuilder() {
    override fun build() = message.built?.let(Components::checkbox)?.apply(::applyTo)
}

fun CheckboxBuilder.applyTo(component: CheckboxComponent) {
    (this as CheckboxWidgetBuilder).applyTo(component)

    checked.built?.let(component::checked)
}
