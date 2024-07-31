package io.github.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ScrollableWidget

abstract class ScrollableWidgetBuilder : ClickableWidgetBuilder() {
    override fun buildComponent(): ScrollableWidget? = null
}
