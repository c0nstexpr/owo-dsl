package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import net.minecraft.client.gui.widget.ButtonWidget

open class ButtonWidgetProvider : PressableWidgetProvider() {
    override fun provide() =
        message.built?.let { ButtonWidget.builder(it) {} }?.build()?.also(::applyTo)
}
