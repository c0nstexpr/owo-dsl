package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ButtonWidget

abstract class ButtonWidgetBuilder<T : ButtonWidget> : PressableWidgetBuilder<ButtonWidget>() {
    override val canBuild get() = messageBuilder.canBuild
}

inline fun buttonWidget(crossinline block: ButtonWidgetBuilder<ButtonWidget>.() -> Unit) =
    object : ButtonWidgetBuilder<ButtonWidget>() {
        override fun build() = ButtonWidget.builder(messageBuilder.build()) {}.build()
    }.apply(block)
