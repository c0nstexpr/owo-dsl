package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.base.BaseParentComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment

abstract class BaseParentComponentBuilder :
    BaseComponentBuilder(),
    ParentComponentBuilder {
    override var verticalAlignment = nullBuilder<VerticalAlignment>()

    override var horizontalAlignment = nullBuilder<HorizontalAlignment>()

    override var padding = nullBuilder<Insets>()

    override var allowOverflow = nullBuilder<Boolean>()

    override var surface = nullBuilder<Surface>()

    abstract override fun build(): BaseParentComponent?
}

fun BaseParentComponentBuilder.applyTo(component: BaseParentComponent) {
    (this as BaseComponentBuilder).applyTo(component)
    (this as ParentComponentBuilder).applyTo(component)
}
