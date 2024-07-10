package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ButtonWidget

abstract class ButtonWidgetBuilder<T : ButtonWidget> : PressableWidgetBuilder<ButtonWidget>()

inline fun buttonWidget(crossinline block: ButtonWidgetBuilder<ButtonWidget>.() -> Unit) =
    object : ButtonWidgetBuilder<ButtonWidget>() {
        override fun build() = messageBuilder.build()?.let { ButtonWidget.builder(it) {}.build() }
    }.apply(block)
