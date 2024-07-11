package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.CursorStyle
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.PositioningBuilder
import org.c0nstexpr.owo.dsl.SizingBuilder

interface ComponentBuilder<T : Component> : OwoBuilder<T> {
    var positioningBuilder: PositioningBuilder

    var marginsBuilder: InsetsBuilder

    var horizontalSizingBuilder: SizingBuilder

    var verticalSizingBuilder: SizingBuilder

    var id: OwoBuilder<String>

    var tooltipBuilder: MutableList<TooltipBuilder<*>>

    var zIndex: OwoBuilder<Int>

    var cursor: OwoBuilder<CursorStyle>

    var x: OwoBuilder<Int>

    var y: OwoBuilder<Int>

    fun applyTo(component: T) {
        if (positioningBuilder.canBuild) component.positioning(positioningBuilder.build())

        if (marginsBuilder.canBuild) component.margins(marginsBuilder.build())

        if (horizontalSizingBuilder.canBuild)
            component.horizontalSizing(horizontalSizingBuilder.build())

        if (verticalSizingBuilder.canBuild) component.verticalSizing(verticalSizingBuilder.build())

        if (id.canBuild) component.id(id.build())

        if (tooltipBuilder.isNotEmpty())
            component.tooltip(tooltipBuilder.filter { it.canBuild }.map { it.build() })

        if (zIndex.canBuild) component.zIndex(zIndex.build())

        if (cursor.canBuild) component.cursorStyle(cursor.build())

        if (x.canBuild) component.updateX(x.build())

        if (y.canBuild) component.updateY(y.build())
    }
}

inline val ComponentBuilder<*>.positioning get() = positioningBuilder

inline fun ComponentBuilder<*>.positioning(crossinline block: (PositioningBuilder) -> Unit) =
    block(positioningBuilder)

inline val ComponentBuilder<*>.margins get() = marginsBuilder

inline fun ComponentBuilder<*>.margins(crossinline block: InsetsBuilder.() -> Unit) =
    block(marginsBuilder)

inline val ComponentBuilder<*>.horizontalSizing
    get() = horizontalSizingBuilder

inline fun ComponentBuilder<*>.horizontalSizing(crossinline block: SizingBuilder.() -> Unit) =
    block(horizontalSizingBuilder)

inline val ComponentBuilder<*>.verticalSizing get() = verticalSizingBuilder

inline fun ComponentBuilder<*>.verticalSizing(crossinline block: SizingBuilder.() -> Unit) =
    block(verticalSizingBuilder)

inline fun ComponentBuilder<*>.sizing(crossinline block: SizingBuilder.() -> Unit) {
    horizontalSizing(block)
    verticalSizing(block)
}

inline fun ComponentBuilder<*>.tooltip(crossinline block: List<TooltipBuilder<*>>.() -> Unit) {
    tooltipBuilder
    block(tooltipBuilder)
}
