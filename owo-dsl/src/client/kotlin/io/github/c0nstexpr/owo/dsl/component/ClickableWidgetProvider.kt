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

abstract class ClickableWidgetProvider : ComponentProvider {
    override var positioning = nullBuilder<Positioning>()

    override var margins = nullBuilder<Insets>()

    override var horizontalSizing = nullBuilder<Sizing>()

    override var verticalSizing = nullBuilder<Sizing>()

    override var positioningAnimation = nullBuilder<OwoAnimation<Positioning>>()

    override var marginsAnimation = nullBuilder<OwoAnimation<Insets>>()

    override var horizontalSizingAnimation = nullBuilder<OwoAnimation<Sizing>>()

    override var verticalSizingAnimation = nullBuilder<OwoAnimation<Sizing>>()

    override var id: String? = null

    override var tooltip = listOf<TooltipComponent>()

    override var zIndex: Int? = null

    override var cursor: CursorStyle? = null

    override var x: Int? = null

    override var y: Int? = null

    var message = nullBuilder<Text>()

    abstract override fun provide(): ClickableWidget?

    protected fun applyTo(component: ClickableWidget) {
        super.applyTo(component)

        message.built?.let(component::setMessage)
    }
}
