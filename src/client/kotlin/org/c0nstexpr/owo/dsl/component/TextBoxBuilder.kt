package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextBoxComponent

abstract class TextBoxBuilder<T : TextBoxComponent> : TextFieldWidgetBuilder<T>() {
    override val canBuild get() = horizontalSizingBuilder.canBuild

    override fun applyTo(component: T) {
        super.applyTo(component)
        text?.let(component::text)
    }
}

inline fun textBoxComponent(crossinline block: TextBoxBuilder<TextBoxComponent>.() -> Unit) =
    object : TextBoxBuilder<TextBoxComponent>() {
        override fun build() = Components.textBox(horizontalSizingBuilder.build())
    }.apply(block)
