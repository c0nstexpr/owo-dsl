package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.canBuild
import net.minecraft.client.gui.widget.ButtonWidget

open class ButtonWidgetBuilder : PressableWidgetBuilder() {
    override val canBuild get() = message.canBuild

    override fun build() = ButtonWidget.builder(message.build()) {}.build()!!.apply(::applyTo)
}
