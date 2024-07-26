package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.OwoAnimation
import io.github.c0nstexpr.owo.dsl.SizingBuilder
import io.github.c0nstexpr.owo.dsl.animate
import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.CursorStyle
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.tooltip.TooltipComponent

interface ComponentBuilder {
    var positioning: DslBuilder<Positioning>

    var margins: DslBuilder<Insets>

    var horizontalSizing: DslBuilder<Sizing>

    var verticalSizing: DslBuilder<Sizing>

    var positioningAnimation: DslBuilder<OwoAnimation<Positioning>>

    var marginsAnimation: DslBuilder<OwoAnimation<Insets>>

    var horizontalSizingAnimation: DslBuilder<OwoAnimation<Sizing>>

    var verticalSizingAnimation: DslBuilder<OwoAnimation<Sizing>>

    var id: DslBuilder<String>

    var tooltip: DslBuilder<List<TooltipComponent>>

    var zIndex: DslBuilder<Int>

    var cursor: DslBuilder<CursorStyle>

    var x: DslBuilder<Int>

    var y: DslBuilder<Int>

    fun build(): Component?

    fun applyTo(component: Component) {
        positioning.built?.let(component::positioning)
        margins.built?.let(component::margins)
        horizontalSizing.built?.let(component::horizontalSizing)
        verticalSizing.built?.let(component::verticalSizing)
        positioningAnimation.built?.let(component.positioning()::animate)
        marginsAnimation.built?.let(component.margins()::animate)
        horizontalSizingAnimation.built?.let(component.horizontalSizing()::animate)
        verticalSizingAnimation.built?.let(component.verticalSizing()::animate)
        id.built?.let(component::id)
        tooltip.built?.let(component::tooltip)
        zIndex.built?.let(component::zIndex)
        cursor.built?.let(component::cursorStyle)
        x.built?.let(component::updateX)
        y.built?.let(component::updateY)
    }

    fun sizing(block: SizingBuilder) {
        horizontalSizing = block
        verticalSizing = block
    }
}
