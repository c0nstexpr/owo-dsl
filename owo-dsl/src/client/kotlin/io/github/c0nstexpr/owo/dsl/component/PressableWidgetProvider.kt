package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.PressableWidget

abstract class PressableWidgetProvider : ClickableWidgetProvider() {
    override fun provide(): PressableWidget? = null
}
