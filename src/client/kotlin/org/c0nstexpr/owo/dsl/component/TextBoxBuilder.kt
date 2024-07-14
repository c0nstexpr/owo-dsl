package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextBoxComponent
import org.c0nstexpr.owo.dsl.applyBuild

open class TextBoxBuilder : TextFieldWidgetBuilder() {
    override fun build() = Components.textBox(horizontalSizing.build())!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild
}

fun TextBoxBuilder.applyTo(component: TextBoxComponent) {
    (this as TextFieldWidgetBuilder).applyTo(component)

    text.applyBuild(component::text)
}

inline fun textBoxComponent(crossinline block: TextBoxBuilder.() -> Unit) =
    TextBoxBuilder().apply(block)
