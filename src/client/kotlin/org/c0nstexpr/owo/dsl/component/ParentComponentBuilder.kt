package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.VerticalAlignment
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.SurfaceBuilder

interface ParentComponentBuilder<T : ParentComponent> : ComponentBuilder<T> {
    var verticalAlignment: OwoBuilder<VerticalAlignment>
    var horizontalAlignment: OwoBuilder<HorizontalAlignment>
    var padding: InsetsBuilder
    var allowOverflow: OwoBuilder<Boolean>
    var surfaceBuilder: SurfaceBuilder

    override fun applyTo(component: T) {
        super.applyTo(component)

        if (verticalAlignment.canBuild) component.verticalAlignment(verticalAlignment.build())

        if (horizontalAlignment.canBuild) component.horizontalAlignment(horizontalAlignment.build())

        if (padding.canBuild) component.padding(padding.build())

        if (allowOverflow.canBuild) component.allowOverflow(allowOverflow.build())

        if (surfaceBuilder.canBuild) component.surface(surfaceBuilder.build())
    }
}

inline fun ParentComponentBuilder<*>.padding(crossinline block: InsetsBuilder.() -> Unit) =
    block(padding)

inline fun ParentComponentBuilder<*>.surface(crossinline block: SurfaceBuilder.() -> Unit) =
    block(surfaceBuilder)
