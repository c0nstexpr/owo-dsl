package io.github.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components

open class ButtonBuilder(var onPress: (ButtonComponent) -> Unit = {}) : ButtonWidgetBuilder() {
    override fun provide(): ButtonComponent? =
        message.value?.let { Components.button(it) {} }?.also(::applyTo)

    protected fun applyTo(component: ButtonComponent) {
        super.applyTo(component)
        component.onPress(onPress)
    }
}
