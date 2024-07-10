package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.base.BaseParentComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.VerticalAlignment
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.SurfaceBuilder

abstract class BaseParentComponentBuilder<T : BaseParentComponent> :
    BaseComponentBuilder<T>(),
    ParentComponentBuilder<T> {
    override var verticalAlignment: VerticalAlignment? = null

    override var horizontalAlignment: HorizontalAlignment? = null

    override var padding = InsetsBuilder()

    override var allowOverflow: Boolean? = null

    override var surfaceBuilder = SurfaceBuilder { null }

    override fun applyTo(component: T) {
        super<BaseComponentBuilder>.applyTo(component)
        super<ParentComponentBuilder>.applyTo(component)
    }
}
