package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.CursorStyle
import net.minecraft.client.gui.widget.ClickableWidget
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.PositioningBuilder
import org.c0nstexpr.owo.dsl.SizingBuilder
import org.c0nstexpr.owo.dsl.TextBuilder
import org.c0nstexpr.owo.dsl.textOf

abstract class ClickableWidgetBuilder<T : ClickableWidget> : ComponentBuilder<T> {
    override var positioningBuilder = PositioningBuilder()

    override var marginsBuilder = InsetsBuilder()

    override var horizontalSizingBuilder = SizingBuilder()

    override var verticalSizingBuilder = SizingBuilder()

    override var id: String? = null

    override var tooltipBuilder = mutableListOf<TooltipBuilder<*>>()

    override var zIndex: Int? = null

    override var cursor: CursorStyle? = null

    override var x: Int? = null

    override var y: Int? = null

    var messageBuilder: TextBuilder = textOf { "" }
}

inline val ClickableWidgetBuilder<*>.message
    get() = messageBuilder

inline fun ClickableWidgetBuilder<*>.message(crossinline block: TextBuilder.() -> Unit) =
    block(messageBuilder)
