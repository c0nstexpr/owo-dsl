package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.InsetsBuilder
import io.github.c0nstexpr.owo.dsl.SurfaceBuilder
import io.github.c0nstexpr.owo.dsl.applyBuilt
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.VerticalAlignment

interface ParentComponentBuilder : ComponentBuilder {
    var verticalAlignment: DslBuilder<VerticalAlignment>
    var horizontalAlignment: DslBuilder<HorizontalAlignment>
    var padding: InsetsBuilder
    var allowOverflow: DslBuilder<Boolean>
    var surface: SurfaceBuilder

    override fun build(): ParentComponent
}

fun ParentComponentBuilder.applyTo(component: ParentComponent) {
    (this as ComponentBuilder).applyTo(component)

    verticalAlignment.applyBuilt(component::verticalAlignment)
    horizontalAlignment.applyBuilt(component::horizontalAlignment)
    padding.applyBuilt(component::padding)
    allowOverflow.applyBuilt(component::allowOverflow)
    surface.applyBuilt(component::surface)
}
