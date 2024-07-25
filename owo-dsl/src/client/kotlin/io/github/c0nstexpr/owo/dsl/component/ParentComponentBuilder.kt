package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment

interface ParentComponentBuilder : ComponentBuilder {
    var verticalAlignment: DslBuilder<VerticalAlignment>
    var horizontalAlignment: DslBuilder<HorizontalAlignment>
    var padding: DslBuilder<Insets>
    var allowOverflow: DslBuilder<Boolean>
    var surface: DslBuilder<Surface>

    // fun <T : Component> child(block: DslBuilder<T>)

    override fun build(): ParentComponent?
}

fun ParentComponentBuilder.applyTo(component: ParentComponent) {
    (this as ComponentBuilder).applyTo(component)

    verticalAlignment.built?.let(component::verticalAlignment)
    horizontalAlignment.built?.let(component::horizontalAlignment)
    padding.built?.let(component::padding)
    allowOverflow.built?.let(component::allowOverflow)
    surface.built?.let(component::surface)
}
