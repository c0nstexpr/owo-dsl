package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuild
import io.wispforest.owo.ui.component.CheckboxComponent
import io.wispforest.owo.ui.component.Components

open class CheckboxBuilder : CheckboxWidgetBuilder() {
    override fun build() = Components.checkbox(message.build())!!.apply(::applyTo)

    override val canBuild get() = message.canBuild
}

fun CheckboxBuilder.applyTo(component: CheckboxComponent) {
    (this as CheckboxWidgetBuilder).applyTo(component)

    checked.applyBuild(component::checked)
}
