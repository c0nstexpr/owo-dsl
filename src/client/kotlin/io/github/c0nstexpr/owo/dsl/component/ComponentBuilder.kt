package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.InsetsBuilder
import io.github.c0nstexpr.owo.dsl.OwoAnimationBuilder
import io.github.c0nstexpr.owo.dsl.OwoBuilder
import io.github.c0nstexpr.owo.dsl.PositioningBuilder
import io.github.c0nstexpr.owo.dsl.SizingBuilder
import io.github.c0nstexpr.owo.dsl.animate
import io.github.c0nstexpr.owo.dsl.applyBuild
import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.CursorStyle
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Positioning
import io.wispforest.owo.ui.core.Sizing
import net.minecraft.client.gui.tooltip.TooltipComponent

interface ComponentBuilder {
    var positioning: PositioningBuilder

    var margins: InsetsBuilder

    var horizontalSizing: SizingBuilder

    var verticalSizing: SizingBuilder

    var positioningAnimation: OwoAnimationBuilder<Positioning>

    var marginsAnimation: OwoAnimationBuilder<Insets>

    var horizontalSizingAnimation: OwoAnimationBuilder<Sizing>

    var verticalSizingAnimation: OwoAnimationBuilder<Sizing>

    var id: OwoBuilder<String>

    var tooltip: OwoBuilder<List<TooltipComponent>>

    var zIndex: OwoBuilder<Int>

    var cursor: OwoBuilder<CursorStyle>

    var x: OwoBuilder<Int>

    var y: OwoBuilder<Int>

    fun build(): Component

    val canBuild: Boolean
}

fun ComponentBuilder.applyTo(component: Component) {
    positioning.applyBuild(component::positioning)
    margins.applyBuild(component::margins)
    horizontalSizing.applyBuild(component::horizontalSizing)
    verticalSizing.applyBuild(component::verticalSizing)
    positioningAnimation.applyBuild(component.positioning()::animate)
    marginsAnimation.applyBuild(component.margins()::animate)
    horizontalSizingAnimation.applyBuild(component.horizontalSizing()::animate)
    verticalSizingAnimation.applyBuild(component.verticalSizing()::animate)
    id.applyBuild(component::id)
    tooltip.applyBuild(component::tooltip)
    zIndex.applyBuild(component::zIndex)
    cursor.applyBuild(component::cursorStyle)
    x.applyBuild(component::updateX)
    y.applyBuild(component::updateY)
}

fun ComponentBuilder.sizing(block: SizingBuilder) {
    horizontalSizing = block
    verticalSizing = block
}
