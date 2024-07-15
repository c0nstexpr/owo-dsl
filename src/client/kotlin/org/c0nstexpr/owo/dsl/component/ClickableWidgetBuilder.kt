package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.CursorStyle
import net.minecraft.client.gui.widget.ClickableWidget
import org.c0nstexpr.owo.dsl.applyBuild
import org.c0nstexpr.owo.dsl.insets
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.positioning
import org.c0nstexpr.owo.dsl.sizing
import org.c0nstexpr.owo.dsl.text

abstract class ClickableWidgetBuilder : ComponentBuilder {
    override var positioning = positioning()

    override var margins = insets()

    override var horizontalSizing = sizing()

    override var verticalSizing = sizing()

    override var id = invalidBuilder<String>()

    override var tooltip = mutableListOf<TooltipBuilder>()

    override var zIndex = invalidBuilder<Int>()

    override var cursor = invalidBuilder<CursorStyle>()

    override var x = invalidBuilder<Int>()

    override var y = invalidBuilder<Int>()

    var message = text()
}

fun ClickableWidgetBuilder.applyTo(component: ClickableWidget) {
    (this as ComponentBuilder).applyTo(component)

    message.applyBuild(component::setMessage)
}
