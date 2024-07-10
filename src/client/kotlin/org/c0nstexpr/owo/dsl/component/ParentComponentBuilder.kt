package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.VerticalAlignment
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.SurfaceBuilder

interface ParentComponentBuilder<T : ParentComponent> : ComponentBuilder<T> {
    var verticalAlignment: VerticalAlignment?
    var horizontalAlignment: HorizontalAlignment?
    var padding: InsetsBuilder
    var allowOverflow: Boolean?
    var surfaceBuilder: SurfaceBuilder

    override fun applyTo(component: T) {
        super.applyTo(component)
        verticalAlignment?.let(component::verticalAlignment)
        horizontalAlignment?.let(component::horizontalAlignment)
        padding.build()?.let(component::padding)
        allowOverflow?.let(component::allowOverflow)
        surfaceBuilder.build()?.let(component::surface)
    }
}

inline fun <reified T : ParentComponent> ParentComponentBuilder<T>.padding(
    block: InsetsBuilder.() -> Unit
) = block(padding)

inline fun <reified T : ParentComponent> ParentComponentBuilder<T>.surface(
    block: SurfaceBuilder.() -> Unit
) = block(surfaceBuilder)
