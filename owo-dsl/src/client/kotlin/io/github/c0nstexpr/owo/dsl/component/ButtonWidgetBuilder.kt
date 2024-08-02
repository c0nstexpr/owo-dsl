package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ButtonWidget

open class ButtonWidgetBuilder : PressableWidgetBuilder() {
    override fun provide() =
        message.value?.let { ButtonWidget.builder(it) {} }?.build()?.also(::applyTo)
}
