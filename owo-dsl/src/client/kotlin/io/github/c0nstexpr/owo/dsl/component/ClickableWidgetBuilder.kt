package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.OwoAnimation
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.CursorStyle
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.tooltip.TooltipComponent
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.text.Text

abstract class ClickableWidgetBuilder : ComponentBuilder {
    override var positioning = nullBuilder<Positioning>()

    override var margins = nullBuilder<Insets>()

    override var horizontalSizing = nullBuilder<Sizing>()

    override var verticalSizing = nullBuilder<Sizing>()

    override var positioningAnimation = nullBuilder<OwoAnimation<Positioning>>()

    override var marginsAnimation = nullBuilder<OwoAnimation<Insets>>()

    override var horizontalSizingAnimation = nullBuilder<OwoAnimation<Sizing>>()

    override var verticalSizingAnimation = nullBuilder<OwoAnimation<Sizing>>()

    override var id = nullBuilder<String>()

    override var tooltip = nullBuilder<List<TooltipComponent>>()

    override var zIndex = nullBuilder<Int>()

    override var cursor = nullBuilder<CursorStyle>()

    override var x = nullBuilder<Int>()

    override var y = nullBuilder<Int>()

    var message = nullBuilder<Text>()

    abstract override fun build(): ClickableWidget?

    protected fun applyTo(component: ClickableWidget) {
        super.applyTo(component)

        message.built?.let(component::setMessage)
    }
}
