package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components

abstract class ButtonBuilder<T : ButtonComponent> : ButtonWidgetBuilder<T>()

inline fun buttonComponent(crossinline block: ButtonBuilder<ButtonComponent>.() -> Unit) =
    object : ButtonBuilder<ButtonComponent>() {
        override fun build() = Components.button(messageBuilder.build()) {}
    }.apply(block)
