package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.built
import net.minecraft.client.gui.widget.ButtonWidget

open class ButtonWidgetBuilder : PressableWidgetBuilder() {
    override fun build() = message.built?.let {
        ButtonWidget.builder(it) {}
    }?.build()?.apply(::applyTo)
}
