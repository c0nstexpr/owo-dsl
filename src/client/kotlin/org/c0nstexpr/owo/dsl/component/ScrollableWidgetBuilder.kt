package org.c0nstexpr.owo.dsl.component

import net.minecraft.client.gui.widget.ScrollableWidget

abstract class ScrollableWidgetBuilder : ClickableWidgetBuilder() {
    abstract override fun build(): ScrollableWidget
}
