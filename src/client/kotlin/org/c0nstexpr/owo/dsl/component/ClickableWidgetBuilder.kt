package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.CursorStyle
import net.minecraft.client.gui.widget.ClickableWidget
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.PositioningBuilder
import org.c0nstexpr.owo.dsl.SizingBuilder
import org.c0nstexpr.owo.dsl.TextBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.text

abstract class ClickableWidgetBuilder<T : ClickableWidget> : ComponentBuilder<T> {
    override var positioningBuilder = PositioningBuilder()

    override var marginsBuilder = InsetsBuilder()

    override var horizontalSizingBuilder = SizingBuilder()

    override var verticalSizingBuilder = SizingBuilder()

    override var id = invalidBuilder<String>()

    override var tooltipBuilder = mutableListOf<TooltipBuilder<*>>()

    override var zIndex = invalidBuilder<Int>()

    override var cursor = invalidBuilder<CursorStyle>()

    override var x = invalidBuilder<Int>()

    override var y = invalidBuilder<Int>()

    var messageBuilder = text()
}

inline val ClickableWidgetBuilder<*>.message get() = messageBuilder

inline fun ClickableWidgetBuilder<*>.message(crossinline block: TextBuilder.() -> Unit) =
    block(messageBuilder)
