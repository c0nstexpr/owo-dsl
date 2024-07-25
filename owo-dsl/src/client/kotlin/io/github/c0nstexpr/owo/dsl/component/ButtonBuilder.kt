package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import java.util.function.Consumer

open class ButtonBuilder : ButtonWidgetBuilder() {
    var onPress = nullBuilder<Consumer<ButtonComponent>>()

    override fun build(): ButtonComponent? =
        message.built?.let { Components.button(it) {} }?.also(::applyTo)
}

fun ButtonBuilder.applyTo(component: ButtonComponent) {
    (this as ButtonWidgetBuilder).applyTo(component)
    onPress.built?.let(component::onPress)
}
