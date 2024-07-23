package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.AnimationBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.InsetsBuilder
import io.github.c0nstexpr.owo.dsl.PositioningBuilder
import io.github.c0nstexpr.owo.dsl.SizingBuilder
import io.github.c0nstexpr.owo.dsl.animate
import io.github.c0nstexpr.owo.dsl.applyBuilt
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
    positioning.applyBuilt(component::positioning)
    margins.applyBuilt(component::margins)
    horizontalSizing.applyBuilt(component::horizontalSizing)
    verticalSizing.applyBuilt(component::verticalSizing)
    positioningAnimation.applyBuilt(component.positioning()::animate)
    marginsAnimation.applyBuilt(component.margins()::animate)
    horizontalSizingAnimation.applyBuilt(component.horizontalSizing()::animate)
    verticalSizingAnimation.applyBuilt(component.verticalSizing()::animate)
    id.applyBuilt(component::id)
    tooltip.applyBuilt(component::tooltip)
    zIndex.applyBuilt(component::zIndex)
    cursor.applyBuilt(component::cursorStyle)
    x.applyBuilt(component::updateX)
    y.applyBuilt(component::updateY)
}

fun ComponentBuilder.sizing(block: SizingBuilder) {
    horizontalSizing = block
    verticalSizing = block
}

inline fun <reified T : ComponentBuilder, U : Component> component(
    instance: T,
    crossinline buildBlock: T.() -> U
): DslBuilder<U> = instance.run { dslBuilder(::canBuild) { buildBlock(this) } }
