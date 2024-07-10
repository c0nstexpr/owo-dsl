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

    var id: String?

    var tooltipBuilder: MutableList<TooltipBuilder<*>>

    var zIndex: Int?

    var cursor: CursorStyle?

    var x: Int?

    var y: Int?

    fun applyTo(component: T) {
        positioningBuilder.build()?.let(component::positioning)

        marginsBuilder.build()?.let(component::margins)

        horizontalSizingBuilder.build()?.let(component::horizontalSizing)
        verticalSizingBuilder.build()?.let(component::verticalSizing)

        id?.let(component::id)

        if (tooltipBuilder.isNotEmpty()) component.tooltip(tooltipBuilder.map { it.build() })

        zIndex?.let(component::zIndex)

        cursor?.let(component::cursorStyle)

        x?.let(component::updateX)
        y?.let(component::updateY)
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
