package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.DslBuilder.Companion.built
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.ParentComponent
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment

interface ParentComponentProvider : ComponentProvider {
    var verticalAlignment: VerticalAlignment?

    var horizontalAlignment: HorizontalAlignment?

    var padding: DslBuilder<Insets>

    var allowOverflow: Boolean?

    var surface: DslBuilder<Surface>

    override fun provide(): ParentComponent? = null

    fun applyTo(component: ParentComponent) {
        super.applyTo(component)
        verticalAlignment?.let(component::verticalAlignment)
        horizontalAlignment?.let(component::horizontalAlignment)
        padding.built?.let(component::padding)
        allowOverflow?.let(component::allowOverflow)
        surface.built?.let(component::surface)
    }
}

fun parentComponent(): ParentComponentProvider = object :
    ParentComponentProvider,
    ComponentProvider by component() {
    override var verticalAlignment: VerticalAlignment? = null

    override var horizontalAlignment: HorizontalAlignment? = null

    override var padding: DslBuilder<Insets> = nullBuilder()

    override var allowOverflow: Boolean? = null

    override var surface: DslBuilder<Surface> = nullBuilder()

    override fun provide(): ParentComponent? = null
}
