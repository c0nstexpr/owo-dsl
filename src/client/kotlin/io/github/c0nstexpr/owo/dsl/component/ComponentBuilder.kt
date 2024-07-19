package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.AnimationBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.InsetsBuilder
import io.github.c0nstexpr.owo.dsl.PositioningBuilder
import io.github.c0nstexpr.owo.dsl.SizingBuilder
import io.github.c0nstexpr.owo.dsl.animate
import io.github.c0nstexpr.owo.dsl.applyBuild
import io.github.c0nstexpr.owo.dsl.dslBuilder
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

    var positioningAnimation: AnimationBuilder<Positioning>

    var marginsAnimation: AnimationBuilder<Insets>

    var horizontalSizingAnimation: AnimationBuilder<Sizing>

    var verticalSizingAnimation: AnimationBuilder<Sizing>

    var id: DslBuilder<String>

    var tooltip: DslBuilder<List<TooltipComponent>>

    var zIndex: DslBuilder<Int>

    var cursor: DslBuilder<CursorStyle>

    var x: DslBuilder<Int>

    var y: DslBuilder<Int>

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

inline fun <reified T : ComponentBuilder, U : Component> component(
    instance: T,
    crossinline buildBlock: T.() -> U
): DslBuilder<U> = instance.run { dslBuilder(::canBuild) { buildBlock(this) } }
