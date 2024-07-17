package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.insets
import io.github.c0nstexpr.owo.dsl.invalidBuilder
import io.github.c0nstexpr.owo.dsl.surface
import io.wispforest.owo.ui.base.BaseParentComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.VerticalAlignment

abstract class BaseParentComponentBuilder :
    BaseComponentBuilder(),
    ParentComponentBuilder {
    override var verticalAlignment = invalidBuilder<VerticalAlignment>()

    override var horizontalAlignment = invalidBuilder<HorizontalAlignment>()

    override var padding = insets()

    override var allowOverflow = invalidBuilder<Boolean>()

    override var surface = surface(invalidBuilder())

    abstract override fun build(): BaseParentComponent
}

fun BaseParentComponentBuilder.applyTo(component: BaseParentComponent) {
    (this as BaseComponentBuilder).applyTo(component)
    (this as ParentComponentBuilder).applyTo(component)
}
