package org.c0nstexpr.owo.dsl.component

import io.wispforest.owo.ui.base.BaseParentComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.VerticalAlignment
import org.c0nstexpr.owo.dsl.InsetsBuilder
import org.c0nstexpr.owo.dsl.invalidBuilder
import org.c0nstexpr.owo.dsl.invalidSurface

abstract class BaseParentComponentBuilder<T : BaseParentComponent> :
    BaseComponentBuilder<T>(),
    ParentComponentBuilder<T> {
    override var verticalAlignment = invalidBuilder<VerticalAlignment>()

    override var horizontalAlignment = invalidBuilder<HorizontalAlignment>()

    override var padding = InsetsBuilder()

    override var allowOverflow = invalidBuilder<Boolean>()

    override var surfaceBuilder = invalidSurface()

    override fun applyTo(component: T) {
        super<BaseComponentBuilder>.applyTo(component)
        super<ParentComponentBuilder>.applyTo(component)
    }
}
