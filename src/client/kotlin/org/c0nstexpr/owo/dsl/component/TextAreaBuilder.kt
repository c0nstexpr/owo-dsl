package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextAreaComponent

abstract class TextAreaBuilder<T : TextAreaComponent> : EditBoxBuilder<T>() {
    var displayCharCount: Boolean? = null

    var maxLines: Int? = null

    override fun applyTo(component: T) {
        super.applyTo(component)
        displayCharCount?.let(component::displayCharCount)
        maxLines?.let(component::maxLines)
    }
}

inline fun textArea(crossinline block: TextAreaBuilder<TextAreaComponent>.() -> Unit) =
    object : TextAreaBuilder<TextAreaComponent>() {
        override fun build(): TextAreaComponent? {
            return Components.textArea(
                horizontalSizingBuilder.build() ?: return null,
                verticalSizingBuilder.build() ?: return null
            )
        }
    }.apply(block)
