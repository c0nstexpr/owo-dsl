package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.github.c0nstexpr.owo.dsl.canBuild
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.component.TextBoxComponent

open class TextBoxBuilder : TextFieldWidgetBuilder() {
    override fun build() = Components.textBox(horizontalSizing.build())!!.apply(::applyTo)

    override val canBuild get() = horizontalSizing.canBuild
}

fun TextBoxBuilder.applyTo(component: TextBoxComponent) {
    (this as TextFieldWidgetBuilder).applyTo(component)

    text.applyBuilt(component::text)
}
