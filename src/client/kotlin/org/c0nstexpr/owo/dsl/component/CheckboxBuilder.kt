package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.CheckboxComponent
import io.wispforest.owo.ui.component.Components
import org.c0nstexpr.owo.dsl.applyBuild

open class CheckboxBuilder : CheckboxWidgetBuilder() {
    override fun build() = Components.checkbox(message.build())!!.apply(::applyTo)
}

fun CheckboxBuilder.applyTo(component: CheckboxComponent) {
    (this as CheckboxWidgetBuilder).applyTo(component)

    checked.applyBuild(component::checked)
}

inline fun checkbox(crossinline block: CheckboxBuilder.() -> Unit) = CheckboxBuilder().apply(block)
