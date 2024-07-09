package org.c0nstexpr.owo.dsl

import io.wispforest.owo.ui.core.Component

interface ComponentBuilder<T : Component> : OwoBuilder<T> {
    val positioningBuilder: PositioningBuilder

    val marginsBuilder: InsetsBuilder

    val horizontalSizingBuilder: SizingBuilder

    val verticalSizingBuilder: SizingBuilder

    val idBuilder: StringBuilder

    val tooltipBuilder: List<TooltipBuilder>

    val zIndex: IntBuilder

    val x: IntBuilder

    val y: IntBuilder
}

fun <T : Component> ComponentBuilder<T>.applyTo(t: T) {
    positioningBuilder.build()?.let(t::positioning)

    marginsBuilder.build()?.let(t::margins)

    horizontalSizingBuilder.build()?.let(t::horizontalSizing)
    verticalSizingBuilder.build()?.let(t::verticalSizing)

    idBuilder.build()?.let(t::id)

    if (tooltipBuilder.isNotEmpty()) t.tooltip(tooltipBuilder.mapNotNull { it.build() })

    zIndex.build()?.let(t::zIndex)
}

val <T : Component> ComponentBuilder<T>.positioning get() = positioningBuilder

fun <T : Component> ComponentBuilder<T>.positioning(block: (PositioningBuilder) -> Unit) =
    block(positioningBuilder)

val <T : Component> ComponentBuilder<T>.margins get() = marginsBuilder

fun <T : Component> ComponentBuilder<T>.margins(block: InsetsBuilder.() -> Unit) =
    block(marginsBuilder)

val <T : Component> ComponentBuilder<T>.horizontalSizing get() = horizontalSizingBuilder

fun <T : Component> ComponentBuilder<T>.horizontalSizing(block: SizingBuilder.() -> Unit) =
    block(horizontalSizingBuilder)

val <T : Component> ComponentBuilder<T>.verticalSizing get() = verticalSizingBuilder

fun <T : Component> ComponentBuilder<T>.verticalSizing(block: SizingBuilder.() -> Unit) =
    block(verticalSizingBuilder)

fun <T : Component> ComponentBuilder<T>.sizing(block: SizingBuilder.() -> Unit) {
    horizontalSizing(block)
    verticalSizing(block)
}

val <T : Component> ComponentBuilder<T>.id get() = idBuilder.build()

fun <T : Component> ComponentBuilder<T>.id(block: StringBuilder.() -> Unit) {
    block(idBuilder)
}

fun <T : Component> ComponentBuilder<T>.id(block: () -> String) {
    idBuilder.builder = OwoBuilder(block)
}

fun <T : Component> ComponentBuilder<T>.tooltip(block: List<TooltipBuilder>.() -> Unit) {
    tooltipBuilder
    block(tooltipBuilder)
}
