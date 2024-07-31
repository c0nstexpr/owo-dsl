package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components

open class ButtonBuilder(var onPress: (ButtonComponent) -> Unit = {}) : ButtonWidgetBuilder() {
    override fun buildComponent(): ButtonComponent? =
        message.built?.let { Components.button(it) {} }?.also(::applyTo)

    protected fun applyTo(component: ButtonComponent) {
        super.applyTo(component)
        component.onPress(onPress)
    }
}
