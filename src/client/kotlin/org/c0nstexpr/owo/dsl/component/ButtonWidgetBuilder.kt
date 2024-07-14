package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ButtonWidget

open class ButtonWidgetBuilder : PressableWidgetBuilder() {
    override val canBuild get() = message.canBuild

    override fun build() = ButtonWidget.builder(message.build()) {}.build()!!.apply(::applyTo)
}

inline fun buttonWidget(crossinline block: ButtonWidgetBuilder.() -> Unit) =
    object : ButtonWidgetBuilder() {}.apply(block)
