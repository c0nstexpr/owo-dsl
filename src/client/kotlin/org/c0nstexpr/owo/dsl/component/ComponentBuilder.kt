package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.CursorStyle
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.PositioningBuilder
import org.c0nstexpr.owo.dsl.SizingBuilder

interface ComponentBuilder : OwoBuilder<Component> {
    var positioning: PositioningBuilder

    var margins: InsetsBuilder

    var horizontalSizing: SizingBuilder

    var verticalSizing: SizingBuilder

    var id: OwoBuilder<String>

    var tooltip: MutableList<TooltipBuilder>

    var zIndex: OwoBuilder<Int>

    var cursor: OwoBuilder<CursorStyle>

    var x: OwoBuilder<Int>

    var y: OwoBuilder<Int>

    override fun build(): Component
}

fun ComponentBuilder.applyTo(component: Component) {
    if (positioning.canBuild) component.positioning(positioning.build())

    if (margins.canBuild) component.margins(margins.build())

    if (horizontalSizing.canBuild) component.horizontalSizing(
        horizontalSizing.build()
    )

    if (verticalSizing.canBuild) component.verticalSizing(verticalSizing.build())

    if (id.canBuild) component.id(id.build())

    if (tooltip.isNotEmpty()) component.tooltip(tooltip.filter { it.canBuild }.map { it.build() })

    if (zIndex.canBuild) component.zIndex(zIndex.build())

    if (cursor.canBuild) component.cursorStyle(cursor.build())

    if (x.canBuild) component.updateX(x.build())

    if (y.canBuild) component.updateY(y.build())
}

fun ComponentBuilder.sizing(block: SizingBuilder) {
    horizontalSizing = block
    verticalSizing = block
}

inline fun ComponentBuilder.tooltip(crossinline block: List<TooltipBuilder>.() -> Unit) =
    block(tooltip)
