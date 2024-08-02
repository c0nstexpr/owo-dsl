package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.nullBuilder
import io.wispforest.owo.ui.base.BaseParentComponent
import io.wispforest.owo.ui.core.HorizontalAlignment
import io.wispforest.owo.ui.core.Insets
import io.wispforest.owo.ui.core.Surface
import io.wispforest.owo.ui.core.VerticalAlignment

abstract class BaseParentComponentBuilder :
    BaseComponentBuilder(),
    ParentComponentBuilder {
    override var verticalAlignment: VerticalAlignment? = null

    override var horizontalAlignment: HorizontalAlignment? = null

    override var padding: DslBuilder<Insets> = nullBuilder()

    override var allowOverflow: Boolean? = null

    override var surface: DslBuilder<Surface> = nullBuilder()

    protected fun configure(component: BaseParentComponent) {
        super<BaseComponentBuilder>.configure(component)
        super<ParentComponentBuilder>.configure(component)
    }
}
