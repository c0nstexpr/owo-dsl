package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.component.Components

open class ButtonBuilder : ButtonWidgetBuilder() {
    override fun build() = Components.button(message.build()) {}!!.apply(::applyTo)
}

inline fun buttonComponent(crossinline block: ButtonBuilder.() -> Unit) =
    object : ButtonBuilder() {}.apply(block)
