package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.VerticalAlignment
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.OwoBuilder
import org.c0nstexpr.owo.dsl.SurfaceBuilder
import org.c0nstexpr.owo.dsl.applyBuild

interface ParentComponentBuilder : ComponentBuilder {
    var verticalAlignment: OwoBuilder<VerticalAlignment>
    var horizontalAlignment: OwoBuilder<HorizontalAlignment>
    var padding: InsetsBuilder
    var allowOverflow: OwoBuilder<Boolean>
    var surface: SurfaceBuilder
}

fun ParentComponentBuilder.applyTo(component: ParentComponent) {
    (this as ComponentBuilder).applyTo(component)

    verticalAlignment.applyBuild(component::verticalAlignment)
    horizontalAlignment.applyBuild(component::horizontalAlignment)
    padding.applyBuild(component::padding)
    allowOverflow.applyBuild(component::allowOverflow)
    surface.applyBuild(component::surface)
}
