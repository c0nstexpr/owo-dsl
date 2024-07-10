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
        if (padding.canBuild) component.padding(padding.build())
        allowOverflow?.let(component::allowOverflow)
        if (surfaceBuilder.canBuild) component.surface(surfaceBuilder.build())
    }
}

inline fun ParentComponentBuilder<*>.padding(crossinline block: InsetsBuilder.() -> Unit) =
    block(padding)

inline fun ParentComponentBuilder<*>.surface(crossinline block: SurfaceBuilder.() -> Unit) =
    block(surfaceBuilder)
