package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextBoxComponent

open class TextBoxProvider : TextFieldWidgetProvider() {
    override fun provide() = horizontalSizing.built?.let(Components::textBox)?.also(::applyTo)

    protected fun applyTo(component: TextBoxComponent) {
        super.applyTo(component)
        text?.let(component::text)
    }
}
