package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextBoxComponent

open class TextBoxBuilder : TextFieldWidgetBuilder() {
    override fun provide() = horizontalSizing.value?.let(Components::textBox)?.also(::applyTo)

    protected fun applyTo(component: TextBoxComponent) {
        super.applyTo(component)
        text?.let(component::text)
    }
}
