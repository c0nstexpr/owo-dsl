package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ScrollableWidget

abstract class ScrollableWidgetProvider : ClickableWidgetProvider() {
    override fun provide(): ScrollableWidget? = null
}
