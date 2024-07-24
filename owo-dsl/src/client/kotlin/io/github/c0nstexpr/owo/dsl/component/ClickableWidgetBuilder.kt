package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.OwoAnimation
import io.github.c0nstexpr.owo.dsl.built
import io.github.c0nstexpr.owo.dsl.insets
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.positioning
import io.github.c0nstexpr.owo.dsl.sizing
import io.github.c0nstexpr.owo.dsl.text
import io.wispforest.owo.ui.core.CursorStyle
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.tooltip.TooltipComponent
import net.minecraft.client.gui.widget.ClickableWidget

abstract class ClickableWidgetBuilder : ComponentBuilder {
    override var positioning = positioning()

    override var margins = insets()

    override var horizontalSizing = sizing()

    override var verticalSizing = sizing()

    override var positioningAnimation = invalidBuilder<OwoAnimation<Positioning>>()

    override var marginsAnimation = invalidBuilder<OwoAnimation<Insets>>()

    override var horizontalSizingAnimation = invalidBuilder<OwoAnimation<Sizing>>()

    override var verticalSizingAnimation = invalidBuilder<OwoAnimation<Sizing>>()

    override var id = invalidBuilder<String>()

    override var tooltip = invalidBuilder<List<TooltipComponent>>()

    override var zIndex = invalidBuilder<Int>()

    override var cursor = invalidBuilder<CursorStyle>()

    override var x = invalidBuilder<Int>()

    override var y = invalidBuilder<Int>()

    var message = text()

    abstract override fun build(): ClickableWidget?
}

fun ClickableWidgetBuilder.applyTo(component: ClickableWidget) {
    (this as ComponentBuilder).applyTo(component)

    message.built?.let(component::setMessage)
}
