package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.OwoAnimation
import io.github.c0nstexpr.owo.dsl.OwoAnimation.Companion.animate
import io.github.c0nstexpr.owo.dsl.SizingBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.CursorStyle
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.tooltip.TooltipComponent

interface ComponentProvider {
    var positioning: DslBuilder<Positioning>

    var margins: DslBuilder<Insets>

    var horizontalSizing: DslBuilder<Sizing>

    var verticalSizing: DslBuilder<Sizing>

    var positioningAnimation: DslBuilder<OwoAnimation<Positioning>>

    var marginsAnimation: DslBuilder<OwoAnimation<Insets>>

    var horizontalSizingAnimation: DslBuilder<OwoAnimation<Sizing>>

    var verticalSizingAnimation: DslBuilder<OwoAnimation<Sizing>>

    var id: String?

    var tooltip: List<TooltipComponent>

    var zIndex: Int?

    var cursor: CursorStyle?

    var x: Int?

    var y: Int?

    fun provide(): Component? = null

    fun applyTo(component: Component) {
        positioning.built?.let(component::positioning)
        margins.built?.let(component::margins)
        horizontalSizing.built?.let(component::horizontalSizing)
        verticalSizing.built?.let(component::verticalSizing)
        positioningAnimation.built?.let { component.positioning().animate(it) }
        marginsAnimation.built?.let { component.margins().animate(it) }
        horizontalSizingAnimation.built?.let { component.horizontalSizing().animate(it) }
        verticalSizingAnimation.built?.let { component.verticalSizing().animate(it) }
        id?.let(component::id)
        tooltip.let(component::tooltip)
        zIndex?.let(component::zIndex)
        cursor?.let(component::cursorStyle)
        x?.let(component::updateX)
        y?.let(component::updateY)
    }

    fun sizing(block: SizingBuilder) {
        horizontalSizing = block
        verticalSizing = block
    }
}

fun componentProvider() = object : ComponentProvider {
    override var positioning = nullBuilder<Positioning>()

    override var margins = nullBuilder<Insets>()

    override var horizontalSizing = nullBuilder<Sizing>()

    override var verticalSizing = nullBuilder<Sizing>()

    override var positioningAnimation = nullBuilder<OwoAnimation<Positioning>>()

    override var marginsAnimation = nullBuilder<OwoAnimation<Insets>>()

    override var horizontalSizingAnimation = nullBuilder<OwoAnimation<Sizing>>()

    override var verticalSizingAnimation = nullBuilder<OwoAnimation<Sizing>>()

    override var id: String? = null

    override var tooltip: List<TooltipComponent> = emptyList()

    override var zIndex: Int? = null

    override var cursor: CursorStyle? = null

    override var x: Int? = null

    override var y: Int? = null
}
