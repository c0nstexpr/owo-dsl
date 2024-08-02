package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.PressableWidget

abstract class PressableWidgetBuilder : ClickableWidgetBuilder() {
    override fun provide(): PressableWidget? = null
}
