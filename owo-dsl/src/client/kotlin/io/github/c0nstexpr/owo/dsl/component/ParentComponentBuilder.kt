package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment

interface ParentComponentBuilder : ComponentBuilder {
    var verticalAlignment: VerticalAlignment?

    var horizontalAlignment: HorizontalAlignment?

    var padding: DslBuilder<Insets>

    var allowOverflow: Boolean?

    var surface: DslBuilder<Surface>

    fun configure(component: ParentComponent) {
        super.configure(component)
        verticalAlignment?.let(component::verticalAlignment)
        horizontalAlignment?.let(component::horizontalAlignment)
        padding.value?.let(component::padding)
        allowOverflow?.let(component::allowOverflow)
        surface.value?.let(component::surface)
    }
}

fun parentComponentBuilder(): ParentComponentBuilder = object :
    ParentComponentBuilder,
    ComponentBuilder by componentBuilder() {
    override var verticalAlignment: VerticalAlignment? = null

    override var horizontalAlignment: HorizontalAlignment? = null

    override var padding: DslBuilder<Insets> = nullBuilder()

    override var allowOverflow: Boolean? = null

    override var surface: DslBuilder<Surface> = nullBuilder()
}
